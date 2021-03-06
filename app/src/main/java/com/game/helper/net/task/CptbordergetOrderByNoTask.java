package com.game.helper.net.task;

import com.game.helper.net.base.BaseBBXTask;
import com.game.helper.sdk.model.comm.CptbordergetOrderByNoBuild;
import com.game.helper.sdk.net.comm.CptbordergetOrderByNoNet;
import android.content.Context;

/**
 * @Description
 * @Path com.game.helper.net.task.CptbordergetOrderByNoTask.java
 * @Author lbb
 * @Date 2016年11月30日 下午2:43:27
 * @Company 
 */
public class CptbordergetOrderByNoTask  extends BaseBBXTask{
	CptbordergetOrderByNoBuild build;
	public CptbordergetOrderByNoTask(Context context,String orderNo,Back back) {
		super(context);
		this.back=back;
		build=new CptbordergetOrderByNoBuild(context, API_cptbordergetOrderByNo_Url, orderNo);
	}
	@Override
	public void onSuccess(Object object, String msg) {
		// TODO Auto-generated method stub
		if(back!=null){
			back.success(object,msg);
		}
	}

	@Override
	public void onFailed(String status, String msg, Object result) {
		// TODO Auto-generated method stub
		super.onFailed(status, msg, result);
       if(back!=null){
    	   back.fail(status, msg, result);
		}
	}

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		return new CptbordergetOrderByNoNet(context, build.toJson1());
	}
	
}
