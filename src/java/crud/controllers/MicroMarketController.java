package crud.controllers;

import crud.controllers.util.MobilePageController;
import crud.entity.MicroMarket;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "microMarketController")
@ViewScoped
public class MicroMarketController extends AbstractController<MicroMarket> {

    @Inject
    private MobilePageController mobilePageController;

    public MicroMarketController() {
        // Inform the Abstract parent controller of the concrete MicroMarket Entity
        super(MicroMarket.class);
    }

    /**
     * Sets the "items" attribute with a collection of Customer entities that
     * are retrieved from MicroMarket?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Customer page
     */
    public String navigateCustomerList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Customer_items", this.getSelected().getCustomerList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/customer/index";
    }

}
