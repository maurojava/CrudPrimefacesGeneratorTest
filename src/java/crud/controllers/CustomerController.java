package crud.controllers;

import crud.controllers.util.MobilePageController;
import crud.entity.Customer;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "customerController")
@ViewScoped
public class CustomerController extends AbstractController<Customer> {

    @Inject
    private DiscountCodeController discountCodeController;
    @Inject
    private MicroMarketController zipController;
    @Inject
    private MobilePageController mobilePageController;

    public CustomerController() {
        // Inform the Abstract parent controller of the concrete Customer Entity
        super(Customer.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        discountCodeController.setSelected(null);
        zipController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PurchaseOrder entities
     * that are retrieved from Customer?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PurchaseOrder page
     */
    public String navigatePurchaseOrderList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PurchaseOrder_items", this.getSelected().getPurchaseOrderList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/purchaseOrder/index";
    }

    /**
     * Sets the "selected" attribute of the DiscountCode controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDiscountCode(ActionEvent event) {
        if (this.getSelected() != null && discountCodeController.getSelected() == null) {
            discountCodeController.setSelected(this.getSelected().getDiscountCode());
        }
    }

    /**
     * Sets the "selected" attribute of the MicroMarket controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareZip(ActionEvent event) {
        if (this.getSelected() != null && zipController.getSelected() == null) {
            zipController.setSelected(this.getSelected().getZip());
        }
    }
}
