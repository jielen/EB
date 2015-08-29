package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbSellerDAO;
import com.ufgov.gk.server.ebay.service.IEbSellerService;

public class EbSellerService implements IEbSellerService {

  private EbSellerDAO ebSellerDao;

  @Override
  public void saveEbSeller(EbSeller seller, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebSellerDao.insert(seller);
    } else {
      this.ebSellerDao.updateByPrimaryKey(seller);
    }
  }

  @Override
  public int deleteEbSeller(EbSeller seller, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerDao.deleteByPrimaryKey(seller.getSellerId());
  }

  @Override
  public EbSeller getEbSellerByID(String sellerId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerDao.selectByPrimaryKey(sellerId);
  }

  @Override
  public List getEbSeller(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbSellerExample example = new EbSellerExample();
    example.setOrderByClause(" group_id,feedback desc,seller_id,register_date desc");
    return this.ebSellerDao.selectByExample(example);
  }

  public EbSellerDAO getEbSellerDao() {
    return ebSellerDao;
  }

  public void setEbSellerDao(EbSellerDAO ebSellerDao) {
    this.ebSellerDao = ebSellerDao;
  }

  @Override
  public void updateEbSeller(EbSeller seller, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if (this.ebSellerDao.selectByPrimaryKey(seller.getSellerId()) != null) {
      this.ebSellerDao.updateByPrimaryKey(seller);
    } else {
      this.ebSellerDao.insert(seller);
    }
  }

  @Override
  public List<EbSeller> getEbSeller(EbSellerExample ex, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerDao.selectByExample(ex);
  }

@Override
public boolean changeSellerIdFN(String sellerId, String newSellerId,
		RequestMeta requestMeta) {
	// TODO Auto-generated method stub
	return ebSellerDao.changeSellerIdFN(sellerId, newSellerId);
}

}
