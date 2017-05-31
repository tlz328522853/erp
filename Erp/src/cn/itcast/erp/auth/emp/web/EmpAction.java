package cn.itcast.erp.auth.emp.web;

import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.vo.EmpModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	public EmpModel em = new EmpModel();
	
	//注入业务层接口
	private EmpEbi empEbi;
	public void setEmpEbi(EmpEbi empEbi) {
		this.empEbi = empEbi;
	}
	
	//登录
	public String login(){
		//System.out.println("haha....."+em.getUserName()+","+em.getPwd());
		//页面收集了用户名，密码信息
		//将数据传递到业务层
		//业务层转调数据层
		//进行业务查询，查询结果返回

		EmpModel loginEm = empEbi.login(em.getUserName(),em.getPwd());
		//判断查询结果，如果查询到
		//登录成功，否则登录失败
		if(loginEm == null){
			//登录失败
			//添加登录失败的信息
			this.addActionError("对不起，用户名密码错误！");
			return "loginFail";
		}else{
			//登录成功
			//将登录人信息放入Session，跳转到主页
			ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, loginEm);
			return "loginSuccess";
		}
	}
	
}
