package sample.com.mvp;

public class Presenter implements PresenterImpl {

    private ViewImpl viewImplementation;

    Presenter(ViewImpl viewImpl) {
        viewImplementation = viewImpl;
    }

    @Override
    public void getDataOverNetwork(Model model) {
        viewImplementation.updateTextView(model.getData());
    }

    public void sendNetworkCall() {
       new NetworkCall(this);
    }
}
