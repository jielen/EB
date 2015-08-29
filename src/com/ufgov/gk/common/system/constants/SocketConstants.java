package com.ufgov.gk.common.system.constants;

public interface SocketConstants {
  
  public static final String JH_TYPE_CODE = "JH";

  public static final String GH_TYPE_CODE = "GH";
  
  public static final String CONNECTION_TIMEOUT = "CONNECTION_TIMEOUT";

  public static final String RECEIVE_TIMEOUT = "RECEIVE_TIMEOUT";

  public static final String REMOTE_ADDRESS = "REMOTE_ADDRESS";

  public static final String REMOTE_PORT = "REMOTE_PORT";
  
  public static final String SEND_BUFFER_SIZE = "SEND_BUFFER_SIZE";
  
  public static final String RECE_BUFFER_SIZE = "RECE_BUFFER_SIZE";
  
  //以下是物理处理标志码
  public static final String IO_EXCEPTION = "-111111";
  
  public static final String SOCKET_TIMEOUT_EXCEPTION = "-222222";
  
  public static final String SOCKET_EXCEPTION = "-333333";
  
  public static final String MESSAGE_STRUCTURE_EXCEPTION = "-555555";
  
  public static final String AUTHE_EXCEPTION = "-666666";
  
  public static final String ILLEGAlARGUMENT_EXCEPTION = "-777777";
  
  //以下是业务处理标志码
  public static final String SUCCESS = "000000";
  
  public static final String FAILURE = "999999";
  
  public static final String UNCERTAINTY = "777777";
  
  public static final String OTHER_EXCEPTION = "-444444";
  
}
