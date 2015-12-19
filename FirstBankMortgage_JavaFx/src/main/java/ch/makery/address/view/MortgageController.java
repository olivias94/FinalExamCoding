package ch.makery.address.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;


public class MortgageController {
	
	
	Integer[] terms = {15, 30};

	//@FXML
	//ComboBox HouseCostComboBox = new ComboBox();
	//HouseCostComboBox.setItems(terms);
	@FXML
	private Label incomeLabel = new Label();
	@FXML
	private Label expensesLabel = new Label();
	@FXML
	private Label creditScoreLabel = new Label();
	@FXML
	private Label houseCostLabel = new Label();
	@FXML
	private Label termLabel = new Label();
	@FXML
	private TextField incomeTextField = new TextField();
	@FXML
	private TextField expensesTextField = new TextField();
	@FXML
	private TextField creditScoreTextField = new TextField();
	@FXML
	private TextField houseCostTextField = new TextField();
	@FXML
	private TextField termTextField = new TextField();  
	@FXML
	private Label mpLabel = new Label();
	@FXML
	private Label bLabel = new Label();
	
	



    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
  /* public ArrayList<Object> mortgageCreator(){
	   double cr = Double.parseDouble(creditScoreTextField.getText());
	   double t = Double.parseDouble(termTextField.getText());
	   double hc = Double.parseDouble(houseCostTextField.getText());
	   double i = Double.parseDouble(incomeTextField.getText());
	   double e = Double.parseDouble(expensesTextField.getText());
 
	   double monthlyPayment = Rate.getPayment(cr, t, hc);
	   
	   boolean monthlyPaymentOK = true;
	   if ((monthlyPayment >= (i * .36)) || (monthlyPayment >= ((i + e) * .28))){
		   monthlyPaymentOK = false;
	   }
	   ArrayList<Object> returnThis = new ArrayList<Object>();
	   returnThis.add(monthlyPayment);
	   returnThis.add(monthlyPaymentOK);
	   
	   return returnThis;
   }*/
   @FXML
   public void handleCalculateMortgage(){
	   //ArrayList<Object> mortgage = mortgageCreator();

	   double cr = Double.parseDouble(creditScoreTextField.getText());
	   System.out.println("-------------" + cr + "-----------------");
	   double t = Double.parseDouble(termTextField.getText());
	   double hc = Double.parseDouble(houseCostTextField.getText());
	   double i = Double.parseDouble(incomeTextField.getText());
	   double e = Double.parseDouble(expensesTextField.getText());
 
	   double monthlyPayment = Rate.getPayment(cr, t, hc);
	   
	   boolean monthlyPaymentOK = true;
	   if ((monthlyPayment >= (i * .36)) || (monthlyPayment >= ((i + e) * .28))){
		   monthlyPaymentOK = false;
	   }
	   //ArrayList<Object> returnThis = new ArrayList<Object>();
	   //returnThis.add(monthlyPayment);
	  // returnThis.add(monthlyPaymentOK);
	   //String mp = (String) mortgage.get(0);
	   //boolean b  = (boolean) mortgage.get(1);
	   //String mp = (String) monthlyPayment.toString();
	   mpLabel.setText("Your monthly payment will be $" + monthlyPayment);
	   //boolean b = (boolean) returnThis.get(1);
	   String can_cant = null;
	   if (monthlyPaymentOK == false){
		   can_cant = "House Cost too high";
	   }else{
		   can_cant = " ";
	   }
	   bLabel.setText(can_cant);
   }
   
}