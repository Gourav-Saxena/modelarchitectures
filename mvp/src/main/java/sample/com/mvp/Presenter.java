package sample.com.mvp;

public class Presenter implements PresenterImpl {

    private ViewImpl viewImplementation;
    private NetworkCall networkCall;

    Presenter(ViewImpl viewImpl) {
        viewImplementation = viewImpl;
        networkCall = new NetworkCall(this);
    }

    @Override
    public void getDataOverNetwork(Model model) {
        viewImplementation.updateTextView(model.getData());
    }

    public void sendNetworkCall() {
        networkCall.getData();
    }
}
