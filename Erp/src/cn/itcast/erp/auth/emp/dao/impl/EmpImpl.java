package cn.itcast.erp.auth.emp.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;

//EmpDaoImpl	//EmpH3Impl		//EmpH3MySQLImpl
public class EmpImpl extends HibernateDaoSupport implements EmpDao {

	public EmpModel getByUserNameAndPwd(String userName, String pwd) {
		String hql ="from EmpModel where userName = ? and pwd = ?";
		List<EmpModel> temp = this.getHibernateTemplate().find(hql,userName,pwd);
		//temp中有对象，返回第一个，否则返回null
		return	temp.size()>0 ? temp.get(0):null; 
	}

}
