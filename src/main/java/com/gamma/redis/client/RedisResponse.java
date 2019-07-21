package com.gamma.redis.client;


public class RedisResponse {

    private ResponseData data;

    private RedisResponse(final ResponseData data) {
        this.data = data;
    }

    public RedisResponse() {
        data = new ResponseData(true, "yeah");
    }

    private ResponseData translateToDataObject(String[] lines) {
        String firstLine = lines[0];

        return new ResponseData(false, null);
    }

    @Override
    public String toString() {
        return "RedisResponse{" +
                "data=" + data +
                '}';
    }

    public class ResponseData {
        private boolean isSuccess;
        private String responseMessage;
        public ResponseData(boolean isSuccess, String responseMessage) {
            this.isSuccess = isSuccess;
            this.responseMessage = responseMessage;
        }

        @Override
        public String toString() {
            return "ResponseData{" +
                    "isSuccess=" + isSuccess +
                    ", responseMessage='" + responseMessage + '\'' +
                    '}';
        }
    }
}
