package st.isacc.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import st.isacc.dao.BrandManageDao;
import st.isacc.entity.BrandEntity;


/**
 * Service for show how service Layer
 *
 * @author lihaiyun
 */

@Service
public class BrandManageServiceImpl implements BrandManageService {



	@Autowired(required = true)
	private BrandManageDao brandDao;



	@Transactional
	public List<BrandEntity> getAllBrandList() {
		return this.brandDao.getAllBrandList();
	}


}
