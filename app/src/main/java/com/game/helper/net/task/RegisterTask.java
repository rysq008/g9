package com.game.helper.net.task;

import android.content.Context;
import com.game.helper.net.base.BaseBBXTask;
import com.game.helper.sdk.model.comm.RegisterBuild;
import com.game.helper.sdk.net.comm.RegisterNet;

public class RegisterTask extends BaseBBXTask{
	RegisterBuild build;
	public RegisterTask(Context context,String phone,String checkCode,String pwd,String inviteCode,String channelId,String channelName,String deviceName,Back back) {
		super(context);
		this.back=back;
		build=new RegisterBuild(context, API_register_Url, phone, checkCode, pwd,inviteCode,channelId,channelName,deviceName);
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
		return new RegisterNet(context, build.toJson1());
	}
	

}
