import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

public static void uploadImg2QiNiu(String filePath, String key, String token){
	UploadManager uploadManager = new UploadManager();
	uploadManager.put(filePath, key, token, new UpCompletionHandler() {
		@Override
		public void complete(String key, ResponseInfo info, JSONObject res) {
			if(info.isOK()){
				ClientBaseNativeLib.uploadImg2QiNiuFinish(key);	
			}
			else{
				
			}
		}
	}, null);
}