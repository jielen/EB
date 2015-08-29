package com.ufgov.gk.server.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caucho.hessian.io.AbstractHessianInput;
import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.caucho.hessian.io.SerializerFactory;
import com.caucho.hessian.server.HessianSkeleton;
import com.ufgov.gk.common.system.Publishable;

public class HessianServicePublisher extends GenericServlet {

  private SerializerFactory _serializerFactory = new SerializerFactory();;

  public HessianServicePublisher() {
  }

  public void service(ServletRequest request, ServletResponse response)
    throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    if (!req.getMethod().equals("POST")) {
      res.setStatus(500, "Hessian Requires POST");
      PrintWriter out = res.getWriter();

      res.setContentType("text/html");
      out.println("<h1>Hessian Requires POST</h1>");

      return;
    }

    String serviceId = req.getPathInfo();

    Object serviceBean = SpringContext.getBean(serviceId.substring(1));
    
    if(!(serviceBean instanceof Publishable)){
      throw new RuntimeException(serviceId.substring(1)+"对应的bean没有实现Publishable接口");
    }
    
    HessianSkeleton homeSkeleton = new HessianSkeleton(serviceBean, serviceBean.getClass());

    try {
      InputStream is = request.getInputStream();
      OutputStream os = response.getOutputStream();

      response.setContentType("application/x-hessian");

      int code = is.read();
      int major;
      int minor;
      AbstractHessianInput in;
      AbstractHessianOutput out;

      if (code == 'H') {
        major = is.read();
        minor = is.read();

        if (major != 0x02 || minor != 0x00)
          throw new IOException("Version " + major + "." + minor
            + " is not understood");

        in = new Hessian2Input(is);
        out = new Hessian2Output(os);

        in.readCall();
      } else if (code == 'c') {
        major = is.read();
        minor = is.read();
        
        in = new HessianInput(is);

        if (major >= 2)
          out = new Hessian2Output(os);
        else
          out = new HessianOutput(os);
      } else {
        // XXX: deflate
        throw new IOException(
          "expected 'H' (Hessian 2.0) or 'c' (Hessian 1.0) in hessian input at "
            + code);
      }

      in.setSerializerFactory(_serializerFactory);

      out.setSerializerFactory(_serializerFactory);

      homeSkeleton.invoke(in, out);

      out.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (ServletException e) {
      throw e;
    } catch (Throwable e) {
      throw new ServletException(e);
    } finally {
    }
  }

}
