package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.BankAccount;

public interface IBankAccountDao {

  List getPayBankAccount(int nd, String accoType, String userId);

  public List getPayBank(int nd, String accoType, String userId);

  List getDefaultPayBankAccount(int nd, String isDefault, String coCode, String fundCode, List accoTypeList);

  List getReceBankAccountList(int nd, String userId);

  BankAccount getReceBankAccount(String accName, String bankAccCode, String bankNodeName, String coCode,
    String userId);

  BankAccount getReceBankAccount(BankAccount bankAccount);

  void deleteReceBankAccout(List bankAccountList);

  BankAccount insertReceBankAccount(BankAccount bankAccount);

  int updateReceBankAccount(BankAccount bankAccount);

  BankAccount getDwZeroAccount(int nd, String coCode, String fundCode, String optFundFilterVal);

  List getDwZeroAccountList(int nd, List accoType, String coCode);

  List getDwBaseBankAccountList(int nd, List accoType, String coCode);

  List getSpecialAccountList(int nd, List accoType);

  List getReceAccountInfoList(int nd, String coCode, String product);

  List getPayBankAccountByAccoType(int nd, List accoTypeList);

  List getBankAccountByAccoType(int nd, String coCode, List accoTypeList);

  List getBankAccountByUserId(int nd, String userId, List accoTypeList);

  List getBankAccountByAccNo(int nd,String no);
}
