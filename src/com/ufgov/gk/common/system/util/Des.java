package com.ufgov.gk.common.system.util;

public class Des {
  
  public static void main(String[] args) {
    String bcd="436F6D707574657243656E746572494342435A4A32303039313131393039353833323230313031313139202020202020202020202020202020202020202020202020202020202020202020202020CDF5D2BB2030202020202020202020202020202020202020202020203333303430323139373530383032303030302020202020202020203132303239323034383239202020203120203130303231373331";
    System.out.println(bcd);
    bcd = bcd.toLowerCase();
    StringBuffer result = new StringBuffer();
    Des.xToB(bcd.toCharArray(), result);
    String asc = result.toString();
    System.out.println(Des.bToX("����".getBytes()));
  }

  public static String DesEncode(String inpass, String Key) {
    return DesArith.execute0(inpass, Key);
  }

  public static String DesDecode(String inpass, String Key) {
    return DesArith.execute1(inpass, Key);
  }

  /**
   * ת16����
   * @param in
   * @param out
   * @param len
   */
  public static void bToX(char in[], char out[], int len) {
    DesArith.bToX(in, out, len);
  }

  /**
   * 16����ת��asicc
   * @param in
   * @param resultStr
   * @return
   * @throws IllegalArgumentException
   */
  public static int xToB(char in[], StringBuffer resultStr) throws IllegalArgumentException {
    return DesArith.xToB(in, resultStr);
  }
  
  public static String bToX(byte[] bytes) {
    //return DesArith.bToX(in);
    char[] BToA = "0123456789abcdef".toCharArray() ;   
    StringBuffer temp = new StringBuffer(bytes.length * 2);   
     
    for (int i = 0; i < bytes.length; i++) {   
     int h = ((bytes[i] & 0xf0) >>> 4);   
     int l = (bytes[i] & 0x0f);      
     temp.append(BToA[h]).append( BToA[l]);   
    }   
    return temp.toString() ;  
  }
}

class DesArith {
  public DesArith() {
  }

  private static int findIndex(char in) {
    char collect[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    int i;
    for (i = 0; i < 16; i++)
      if (collect[i] == in)
        break;

    if (i == 16)
      return -1;
    else
      return i;
  }

  public static int xToB(char in[], StringBuffer returnStr) throws IllegalArgumentException {
    int len = in.length;
    if(len % 2 > 0)
     return -1;
    char tmp[] = new char[len / 2];
    for(int i = 0; i < len / 2; i++)
    {
     int j = findIndex(in[i * 2]) * 16;
     int k = findIndex(in[i * 2 + 1]);
     if(j < 0 || k < 0)
      return -1;
     tmp[i] = (char)(j + k);
    }
    for(int i = 0; i < len; i++)
     in[i] = '\0';
    for(int i = 0; i < len / 2; i++)
     in[i] = tmp[i];
    String str = new String(tmp);
    returnStr.append(str);
    return 0;
  }

  public static void bToX(char in[], char out[], int len) {
    char collect[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    for (int i = 0; i < len; i++) {
      out[i * 2] = collect[in[i] / 16];
      out[i * 2 + 1] = collect[in[i] % 16];
    }
  }
  
  public static String bToX(char in[]) {
    char[] buffer = new char[in.length * 2];
    bToX(in, buffer, in.length);
    return new String(buffer);
  }

  private static void textIpRank(char TEXT[]) {
    char buffer[] = new char[8];
    int IP[] = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6,
      64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45,
      37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };
    for (int count = 0; count < 8; count++) {
      buffer[count] = TEXT[count];
      TEXT[count] = '\0';
    }

    for (int count = 0; count < 64; count++) {
      char set;
      if ((buffer[(IP[count] - 1) / 8] & 128 >> (IP[count] - 1) % 8) != 0)
        set = '\200';
      else
        set = '\0';
      TEXT[count / 8] = (char) (TEXT[count / 8] | set >> count % 8);
    }

  }

  private static void textMulChange(char Ln[], char Rn[], char Kn[]) {
    char buffer1[] = new char[6];
    char buffer2[] = new char[4];
    char buffer3[] = new char[4];
    char set = '\200';
    char E[] = { ' ', '\001', '\002', '\003', '\004', '\005', '\004', '\005', '\006', '\007', '\b', '\t',
      '\b', '\t', '\n', '\013', '\f', '\r', '\f', '\r', '\016', '\017', '\020', '\021', '\020', '\021',
      '\022', '\023', '\024', '\025', '\024', '\025', '\026', '\027', '\030', '\031', '\030', '\031', '\032',
      '\033', '\034', '\035', '\034', '\035', '\036', '\037', ' ', '\001' };
    char S[][] = {
      { '\016', '\004', '\r', '\001', '\002', '\017', '\013', '\b', '\003', '\n', '\006', '\f', '\005', '\t',
        '\0', '\007', '\0', '\017', '\007', '\004', '\016', '\002', '\r', '\001', '\n', '\006', '\f', '\013',
        '\t', '\005', '\003', '\b', '\004', '\001', '\016', '\b', '\r', '\006', '\002', '\013', '\017', '\f',
        '\t', '\007', '\003', '\n', '\005', '\0', '\017', '\f', '\b', '\002', '\004', '\t', '\001', '\007',
        '\005', '\013', '\003', '\016', '\n', '\0', '\006', '\r' },
      { '\017', '\001', '\b', '\016', '\006', '\013', '\003', '\004', '\t', '\007', '\002', '\r', '\f', '\0',
        '\005', '\n', '\003', '\r', '\004', '\007', '\017', '\002', '\b', '\016', '\f', '\0', '\001', '\n',
        '\006', '\t', '\013', '\005', '\0', '\016', '\007', '\013', '\n', '\004', '\r', '\001', '\005', '\b',
        '\f', '\006', '\t', '\003', '\002', '\017', '\r', '\b', '\n', '\001', '\003', '\017', '\004', '\002',
        '\013', '\006', '\007', '\f', '\0', '\005', '\016', '\t' },
      { '\n', '\0', '\t', '\016', '\006', '\003', '\017', '\005', '\001', '\r', '\f', '\007', '\013', '\004',
        '\002', '\b', '\r', '\007', '\0', '\t', '\003', '\004', '\006', '\n', '\002', '\b', '\005', '\016',
        '\f', '\013', '\017', '\001', '\r', '\006', '\004', '\t', '\b', '\017', '\003', '\0', '\013', '\001',
        '\002', '\f', '\005', '\n', '\016', '\007', '\001', '\n', '\r', '\0', '\006', '\t', '\b', '\007',
        '\004', '\017', '\016', '\003', '\013', '\005', '\002', '\f' },
      { '\007', '\r', '\016', '\003', '\0', '\006', '\t', '\n', '\001', '\002', '\b', '\005', '\013', '\f',
        '\004', '\017', '\r', '\b', '\013', '\005', '\006', '\017', '\0', '\003', '\004', '\007', '\002',
        '\f', '\001', '\n', '\016', '\t', '\n', '\006', '\t', '\0', '\f', '\013', '\007', '\r', '\017',
        '\001', '\003', '\016', '\005', '\002', '\b', '\004', '\003', '\017', '\0', '\006', '\n', '\001',
        '\r', '\b', '\t', '\004', '\005', '\013', '\f', '\007', '\002', '\016' },
      { '\002', '\f', '\004', '\001', '\007', '\n', '\013', '\006', '\b', '\005', '\003', '\017', '\r', '\0',
        '\016', '\t', '\016', '\013', '\002', '\f', '\004', '\007', '\r', '\001', '\005', '\0', '\017', '\n',
        '\003', '\t', '\b', '\006', '\004', '\002', '\001', '\013', '\n', '\r', '\007', '\b', '\017', '\t',
        '\f', '\005', '\006', '\003', '\0', '\016', '\013', '\b', '\f', '\007', '\001', '\016', '\002', '\r',
        '\006', '\017', '\0', '\t', '\n', '\004', '\005', '\003' },
      { '\f', '\001', '\n', '\017', '\t', '\002', '\006', '\b', '\0', '\r', '\003', '\004', '\016', '\007',
        '\005', '\013', '\n', '\017', '\004', '\002', '\007', '\f', '\t', '\005', '\006', '\001', '\r',
        '\016', '\0', '\013', '\003', '\b', '\t', '\016', '\017', '\005', '\002', '\b', '\f', '\003', '\007',
        '\0', '\004', '\n', '\001', '\r', '\013', '\006', '\004', '\003', '\002', '\f', '\t', '\005', '\017',
        '\n', '\013', '\016', '\001', '\007', '\006', '\0', '\b', '\r' },
      { '\004', '\013', '\002', '\016', '\017', '\0', '\b', '\r', '\003', '\f', '\t', '\007', '\005', '\n',
        '\006', '\001', '\r', '\0', '\013', '\007', '\004', '\t', '\001', '\n', '\016', '\003', '\005', '\f',
        '\002', '\017', '\b', '\006', '\001', '\004', '\013', '\r', '\f', '\003', '\007', '\016', '\n',
        '\017', '\006', '\b', '\0', '\005', '\t', '\002', '\006', '\013', '\r', '\b', '\001', '\004', '\n',
        '\007', '\t', '\005', '\0', '\017', '\016', '\002', '\003', '\f' },
      { '\r', '\002', '\b', '\004', '\006', '\017', '\013', '\001', '\n', '\t', '\003', '\016', '\005', '\0',
        '\f', '\007', '\001', '\017', '\r', '\b', '\n', '\003', '\007', '\004', '\f', '\005', '\006', '\013',
        '\0', '\016', '\t', '\002', '\007', '\013', '\004', '\001', '\t', '\f', '\016', '\002', '\0', '\006',
        '\n', '\r', '\017', '\003', '\005', '\b', '\002', '\001', '\016', '\007', '\004', '\n', '\b', '\r',
        '\017', '\f', '\t', '\0', '\003', '\005', '\006', '\013' } };
    char P[] = { '\020', '\007', '\024', '\025', '\035', '\f', '\034', '\021', '\001', '\017', '\027',
      '\032', '\005', '\022', '\037', '\n', '\002', '\b', '\030', '\016', ' ', '\033', '\003', '\t', '\023',
      '\r', '\036', '\006', '\026', '\013', '\004', '\031' };
    for (int count = 0; count < 6; count++)
      buffer1[count] = '\0';

    for (int count = 0; count < 4; count++) {
      buffer2[count] = '\0';
      buffer3[count] = '\0';
    }

    for (int count = 0; count < 48; count++) {
      if ((Rn[(E[count] - 1) / 8] & 128 >> (E[count] - 1) % 8) != 0)
        set = '\200';
      else
        set = '\0';
      buffer1[count / 8] = (char) (buffer1[count / 8] | set >> count % 8);
    }

    for (int count = 0; count < 6; count++)
      buffer1[count] = (char) (buffer1[count] ^ Kn[count]);

    for (int count = 0; count < 48; count++) {
      if (count % 6 == 0)
        set = '\0';
      if ((buffer1[count / 8] & 128 >> count % 8) != 0)
        set |= '\001';
      else
        set |= '\0';
      if ((count + 1) % 6 == 0) {
        buffer2[count / 12] <<= '\004';
        buffer2[count / 12] |= S[count / 6][(set & 0x20) + ((set & '\001') << 4) + ((set & 0x1e) >> 1)];
      }
      set <<= '\001';
    }

    for (int count = 0; count < 32; count++) {
      if ((buffer2[(P[count] - 1) / 8] & 128 >> (P[count] - 1) % 8) != 0)
        set = '\200';
      else
        set = '\0';
      buffer3[count / 8] = (char) (buffer3[count / 8] | set >> count % 8);
    }

    for (int count = 0; count < 4; count++) {
      set = Rn[count];
      Rn[count] = (char) (buffer3[count] ^ Ln[count]);
      Ln[count] = set;
    }

  }

  private static void textIpWorsen(char TEXT[]) {
    char buffer[] = new char[8];
    int IP_1[] = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62,
      30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2,
      42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 };
    for (int count = 0; count < 8; count++) {
      buffer[count] = TEXT[count];
      TEXT[count] = '\0';
    }

    for (int count = 0; count < 64; count++) {
      char set;
      if ((buffer[(IP_1[count] - 1) / 8] & 128 >> (IP_1[count] - 1) % 8) != 0)
        set = '\200';
      else
        set = '\0';
      TEXT[count / 8] = (char) (TEXT[count / 8] | set >> count % 8);
    }

  }

  private static void keyPc1(char CnDn[], char KEY[]) {
    char keybuf[] = new char[8];
    char buffer[] = new char[7];
    char PC1[] = { '9', '1', ')', '!', '\031', '\021', '\t', '\001', ':', '2', '*', '"', '\032', '\022',
      '\n', '\002', ';', '3', '+', '#', '\033', '\023', '\013', '\003', '<', '4', ',', '$', '?', '7', '/',
      '\'', '\037', '\027', '\017', '\007', '>', '6', '.', '&', '\036', '\026', '\016', '\006', '=', '5',
      '-', '%', '\035', '\025', '\r', '\005', '\034', '\024', '\f', '\004' };
    for (int count = 0; count < 7; count++)
      CnDn[count] = '\0';

    for (int count = 0; count < 8; count++)
      keybuf[count] = KEY[count];

    char set = '\200';
    for (int count = 0; count < 7; count++) {
      keybuf[count] &= '\376';
      buffer[count] = (char) (0xff & (keybuf[count] << count | (keybuf[count + 1] & set) >> 7 - count));
      set = (char) (set >> 1 | 0x80);
    }

    for (int count = 0; count < 56; count++) {
      PC1[count] = (char) (PC1[count] - PC1[count] / 8 - 1);
      if ((buffer[PC1[count] / 8] & 128 >> PC1[count] % 8) != 0)
        set = '\200';
      else
        set = '\0';
      CnDn[count / 8] = (char) (CnDn[count / 8] | set >> count % 8);
    }

  }

  private static void keyLs(char CnDn[]) {
    char set = (char) (CnDn[0] & 0x80);
    for (int count = 0; count < 6; count++)
      CnDn[count] = (char) (0xff & (CnDn[count] << 1 | (CnDn[count + 1] & 0x80) >> 7));

    CnDn[6] <<= '\001';
    CnDn[6] = (char) (0xff & CnDn[6]);
    if ((CnDn[3] & 0x10) != 0)
      CnDn[6] |= '\001';
    CnDn[3] = (char) (CnDn[3] & 0xef | set >> 3);
  }

  private static void keyPc2(char CnDn[], char SKEYn[]) {
    char PC2[] = { '\016', '\021', '\013', '\030', '\001', '\005', '\003', '\034', '\017', '\006', '\025',
      '\n', '\027', '\023', '\f', '\004', '\032', '\b', '\020', '\007', '\033', '\024', '\r', '\002', ')',
      '4', '\037', '%', '/', '7', '\036', '(', '3', '-', '!', '0', ',', '1', '\'', '8', '"', '5', '.', '*',
      '2', '$', '\035', ' ' };
    for (int count = 0; count < 6; count++)
      SKEYn[count] = '\0';

    for (int count = 0; count < 48; count++) {
      char set;
      if ((CnDn[(PC2[count] - 1) / 8] & 128 >> (PC2[count] - 1) % 8) != 0)
        set = '\200';
      else
        set = '\0';
      SKEYn[count / 8] = (char) (SKEYn[count / 8] | set >> count % 8);
    }

  }

  private static void sonKey(char SKEY[][], char KEY[]) {
    char CnDn[] = new char[7];
    char LS[] = { '\001', '\001', '\002', '\002', '\002', '\002', '\002', '\002', '\001', '\002', '\002',
      '\002', '\002', '\002', '\002', '\001' };
    keyPc1(CnDn, KEY);
    for (int count = 0; count < 16; count++) {
      keyLs(CnDn);
      if (LS[count] == '\002')
        keyLs(CnDn);
      keyPc2(CnDn, SKEY[count]);
    }

  }

  private static void icbcDes1(char TEXT[], char KEY[], int mode) {
    char Ln[] = new char[4];
    char Rn[] = new char[4];
    char SKEY[][] = new char[16][6];
    sonKey(SKEY, KEY);
    textIpRank(TEXT);
    Ln[0] = TEXT[0];
    Rn[0] = TEXT[4];
    Ln[1] = TEXT[1];
    Rn[1] = TEXT[5];
    Ln[2] = TEXT[2];
    Rn[2] = TEXT[6];
    Ln[3] = TEXT[3];
    Rn[3] = TEXT[7];
    for (int count = 0; count < 16; count++)
      if (mode != 0)
        textMulChange(Ln, Rn, SKEY[15 - count]);
      else
        textMulChange(Ln, Rn, SKEY[count]);

    TEXT[0] = Rn[0];
    TEXT[4] = Ln[0];
    TEXT[1] = Rn[1];
    TEXT[5] = Ln[1];
    TEXT[2] = Rn[2];
    TEXT[6] = Ln[2];
    TEXT[3] = Rn[3];
    TEXT[7] = Ln[3];
    textIpWorsen(TEXT);
  }

  private static int desPack(char Text[], char Key[], int Block, int Mode) {
    if (Text == null || Key == null)
      return -1;
    for (int i = 0; i < Block; i++) {
      char textNew[] = new char[8];
      for (int j = i * 8; j < i * 8 + 8; j++)
        textNew[j - i * 8] = Text[j];

      icbcDes1(textNew, Key, Mode);
      for (int j = i * 8; j < i * 8 + 8; j++)
        Text[j] = textNew[j - i * 8];

    }

    return 0;
  }

  public static String execute0(String sInPass, String Key)
  //throws Exception
  {
    char sourc1[] = sInPass.toCharArray();
    int blocks = sourc1.length;
    if (blocks < 1)
      //throw new AppException("L9999", "δ��������");
      return "";
    blocks = blocks % 8 == 0 ? blocks / 8 : blocks / 8 + 1;
    char sourc[] = new char[blocks * 8];
    for (int i = 0; i < blocks * 8; i++)
      sourc[i] = '\0';

    for (int i = 0; i < sourc1.length; i++)
      sourc[i] = sourc1[i];
    char t[] = Key.toCharArray();

    if (desPack(sourc, t, blocks, 0) != 0) {
      //throw new Exception("������ܳ���");
      return null;
    } else {
      char dest[] = new char[16 * blocks];
      bToX(sourc, dest, 8 * blocks);
      String sEncPass = new String(dest);
      return sEncPass;
    }
  }

  public static String execute1(String sInPass, String Key)
  //throws Exception
  {
    char sourc1[] = sInPass.toCharArray();
    int blocks = sourc1.length;
    if (blocks < 1)
      //throw new AppException("L9999", "δ��������");
      return "";
    blocks = blocks % 8 == 0 ? blocks / 8 : blocks / 8 + 1;
    char sourc[] = new char[blocks * 8];
    for (int i = 0; i < blocks * 8; i++)
      sourc[i] = '\0';

    for (int i = 0; i < sourc1.length; i++)
      sourc[i] = sourc1[i];
    char t[] = Key.toCharArray();
    if (desPack(sourc, t, blocks, 1) != 0) {
      //throw new Exception("������ܳ���");
      return null;
    } else {
      char dest[] = new char[16 * blocks];
      bToX(sourc, dest, 8 * blocks);
      String sEncPass = new String(dest);
      return sEncPass;
    }
  }
}
