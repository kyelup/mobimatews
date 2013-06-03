package st.isacc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import st.isacc.entity.BrandEntity;
/**
 * Service for show how dao Layer works
 *
 * @author lihaiyun
 */

@Repository
public class BrandManageDaoImpl implements BrandManageDao {

	@Autowired
	private SessionFactory sessionFactory;



	public List<BrandEntity> getAllBrandList() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from BrandEntity").setCacheable(true).list();
	}

}
