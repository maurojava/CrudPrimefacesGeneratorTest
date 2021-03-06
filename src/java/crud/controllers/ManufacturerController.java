package crud.controllers;

import crud.controllers.util.MobilePageController;
import crud.entity.Manufacturer;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "manufacturerController")
@ViewScoped
public class ManufacturerController extends AbstractController<Manufacturer> {

    @Inject
    private MobilePageController mobilePageController;

    public ManufacturerController() {
        // Inform the Abstract parent controller of the concrete Manufacturer Entity
        super(Manufacturer.class);
    }

    /**
     * Sets the "items" attribute with a collection of Product entities that are
     * retrieved from Manufacturer?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Product page
     */
    public String navigateProductList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Product_items", this.getSelected().getProductList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/product/index";
    }

}
