package crud.controllers;

import crud.controllers.util.MobilePageController;
import crud.entity.DiscountCode;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "discountCodeController")
@ViewScoped
public class DiscountCodeController extends AbstractController<DiscountCode> {

    @Inject
    private MobilePageController mobilePageController;

    public DiscountCodeController() {
        // Inform the Abstract parent controller of the concrete DiscountCode Entity
        super(DiscountCode.class);
    }

    /**
     * Sets the "items" attribute with a collection of Customer entities that
     * are retrieved from DiscountCode?cap_first and returns the navigation
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
