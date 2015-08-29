package com.ufgov.gk.common.system.josql;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.josql.QueryExecutionException;
import org.josql.expressions.Expression;
import org.josql.functions.AbstractFunctionHandler;

import com.ufgov.gk.common.system.util.DateUtil;

public class JoSqlFunctions extends AbstractFunctionHandler {

  public BigDecimal sumBigDecimal(Expression exp) throws QueryExecutionException {
    return this.sumBigDecimal((List) this.q.getAllObjects(), exp);
  }

  public BigDecimal sumBigDecimal(List objs, Expression exp) throws QueryExecutionException {
    Class c = null;
    try {
      c = exp.getExpectedReturnType(this.q);
    } catch (Exception e) {
      throw new QueryExecutionException("Unable to determine expected return type for expression: " + exp, e);
    }
    if (!c.getName().equals(BigDecimal.class.getName())) {
      {
        throw new QueryExecutionException("This function expects the expression: " + exp + " to return a  "
          + BigDecimal.class.getName());
      }
    }
    Object co = this.q.getCurrentObject();
    List allobjs = this.q.getAllObjects();
    this.q.setAllObjects(objs);

    int s = objs.size() - 1;
    BigDecimal d = new BigDecimal("0");

    for (int i = s; i > -1; i--) {
      Object o = objs.get(i);
      this.q.setCurrentObject(o);
      Object v = null;
      try {
        v = exp.getValue(o, this.q);
      } catch (Exception e) {
        this.q.setCurrentObject(co);
        this.q.setAllObjects(allobjs);
        throw new QueryExecutionException("Unable to evaluate expression: " + exp + " on item: " + i, e);
      }

      if (v == null) {
        // Skip... i.e. assume it's zero.
        continue;
      }
      d = d.add((BigDecimal) v);
    }
    this.q.setCurrentObject(co);
    this.q.setAllObjects(allobjs);
    return d;
  }

  public String joFormatDate(Object o) throws QueryExecutionException {
    if (o == null) {
      throw new QueryExecutionException("Cannot format a null date.");
    }
    Date d = null;
    if (o instanceof Date) {
      d = (Date) o;
    }
    if (o instanceof Number) {
      d = new Date(((Number) o).longValue());
    }
    if (d == null) {
      throw new QueryExecutionException("Type: " + o.getClass().getName() + " not supported.");
    }
    return DateUtil.dateToDdString(d);
  }

  public int month(Object o) throws QueryExecutionException {
    if (o == null) {
      throw new QueryExecutionException(" null pointer ");
    }
    Date d = null;
    if (o instanceof Date) {
      d = (Date) o;
    }
    if (o instanceof Number) {
      d = new Date(((Number) o).longValue());
    }
    if (d == null) {
      throw new QueryExecutionException("Type: " + o.getClass().getName() + " not supported.");
    }
    Calendar c = Calendar.getInstance();
    c.setTime(d);
    return c.get(Calendar.MONTH) + 1;
  }

}
