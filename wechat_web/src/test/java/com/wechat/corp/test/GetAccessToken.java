package com.wechat.corp.test;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.HttpClient;

import com.wechat.corp.bean.WechatException;
import com.wechat.corp.common.Constants;
import com.wechat.corp.connect.HttpClientFactory;
import com.wechat.corp.connect.WechatClientHCE;



public class GetAccessToken {

	public static void main(String[] args) {
		try {
			WechatClientHCE wc = new WechatClientHCE(Constants.CORP_ID, Constants.ASSISTANT_SECRET);
			HttpClient httpClient = HttpClientFactory.createHttpClient();
			wc.setHttpClient(httpClient);

			String accessToken = wc.getAccessToken();// 调用默认函数获取一次accessToken
			System.out.println("第一次：" + accessToken);
			accessToken = wc.getAccessToken();// 重新获取一次accessToken
			System.out.println("第二次：" + accessToken);
			Thread.sleep(10000);
			accessToken = wc.getAccessToken(true);// 获取一个新的accessToken
			System.out.println("第三次：" + accessToken);
		} catch (WechatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
