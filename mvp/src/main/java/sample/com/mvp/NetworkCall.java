package sample.com.mvp;


public class NetworkCall {

    private PresenterImpl presenterImplementation;

    NetworkCall(PresenterImpl presenter) {
        presenterImplementation = presenter;
    }

    public void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Model model = new Model();
                    model.setData("Gourav");
                    presenterImplementation.getDataOverNetwork(model);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
