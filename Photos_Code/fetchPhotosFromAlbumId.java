public void fetchPhotosFromAlbumId(final String album_id, Activity activity){

    //new FetchAsyncTask().execute(album_id);

    progressDialog1 = ProgressDialog.show(activity,"", "Please wait...");
    System.out.println("progress dialog: "+progressDialog1);

    new Thread(new Runnable() {
        @Override
        public void run() {
            Looper.prepare();

            JSONObject me;
            try {
                fbPhotosList.clear();
                String offset1 = String.valueOf(offset+100);
                Bundle params = new Bundle();
                params.putString("limit", "1000");
                params.putString("access_token", facebook.getAccessToken());

                //me = new JSONObject(facebook.request("me/albums",params ,"GET"));
                me = new JSONObject(facebook.request(album_id+"/photos",params ,"GET"));
                System.out.println(me);

                JSONArray jsonArray = me.getJSONArray("data");
                for (int i = 0; i < jsonArray.length(); i++) {
                    CameraRollBean bean = new CameraRollBean();
                    bean.filePath = jsonArray.getJSONObject(i).getString("source");
                    bean.showRight_IB = false;
                    // This is the list that i need to pass to ImagedownloaderActivity
                    fbPhotosList.add(bean); 
                }
                System.out.println("size of fb album: "+fbAlbumList.size());
                FbAlbumsScreen.fromFbScreen = true;
                Intent intent = new Intent(_activity, CameraRollScreen.class);
                intent.putExtra("album_id", album_id);
                _activity.startActivity(intent);


                if(progressDialog1!=null)
                    progressDialog1.cancel();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }).start();

    progressDialog1.show();
}