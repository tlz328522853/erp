package cn.itcast.erp.auth.emp.business.ebo;

import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.util.format.MD5Utils;


//Enterprice Business Object
public class EmpEbo implements EmpEbi{
	//注入数据层接口
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	public EmpModel login(String userName, String pwd) {
		//MD5加密
		pwd = MD5Utils.md5(pwd);
		//调用数据层
		return empDao.getByUserNameAndPwd(userName,pwd);
	}
	
}
