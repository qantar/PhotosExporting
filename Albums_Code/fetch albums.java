   

// Add this on the on success after the login
// in order to fetch the albums (albums ids and names and our case)
   new GraphRequest(
            AccessToken.getCurrentAccessToken(),
            "/me/albums",
            null,
            HttpMethod.GET,
            new GraphRequest.Callback() {
                public void onCompleted(GraphResponse response) {
                    String [] albumName = null;
                    String [] albumId = null;
                    try{
                        JSONObject json = response.getJSONObject();
                        JSONArray jarray = json.getJSONArray("data");
                        for(int i = 0; i < jarray.length(); i++) {
                            JSONObject oneAlbum = jarray.getJSONObject(i);
                            //get albums names
                            

                                albumName[i] = oneAlbum.getString("name");
                                albumId[i] = oneAlbum.getString("id"),
                            }
                        }
                    }
                    catch(JSONException e){
                        e.printStackTrace();
                    }
            }
        ).execAsyncTask();