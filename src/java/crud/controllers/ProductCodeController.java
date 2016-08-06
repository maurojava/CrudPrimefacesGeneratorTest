package crud.controllers;

import crud.controllers.util.MobilePageController;
import crud.entity.ProductCode;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "productCodeController")
@ViewScoped
public class ProductCodeController extends AbstractController<ProductCode> {

    @Inject
    private MobilePageController mobilePageController;

    public ProductCodeController() {
        // Inform the Abstract parent controller of the concrete ProductCode Entity
        super(ProductCode.class);
    }

    /**
     * Sets the "items" attribute with a collection of Product entities that are
     * retrieved from ProductCode?cap_first and returns the navigation outcome.
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
