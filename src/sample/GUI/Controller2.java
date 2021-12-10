package sample.GUI;

// First attempt to use Default Table Input
// Attempt to add Global Table Input Later

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.PersistantData;
import sample.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {


    private String inputNameText;
    private String inputPathText;

    @FXML
    private TableView<?> mainTable; // May need to rename this to defaultTable

    @FXML
    private TableColumn<?, ?> deviceType;

    @FXML
    private TableColumn<?, ?> symbolName;

    @FXML
    private TableColumn<?, ?> focusPoint;

    @FXML
    private TableColumn<?, ?> vworksClass;

    @FXML
    private TableColumn<?, ?> vworksLayer;

    @FXML
    private TableColumn<?, ?> accessories;

    @FXML
    private TableColumn<?, ?> frameSize;

    @FXML
    private TableColumn<?, ?> numChannels;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> instrumentType;

    @FXML
    private TableColumn<?, ?> unitNumber;

    @FXML
    private TableColumn<?, ?> template2;

    @FXML
    private TableColumn<?, ?> template1;

    @FXML
    private TableColumn<?, ?> color;

    @FXML
    private TableColumn<?, ?> circuitName;

    @FXML
    private TableColumn<?, ?> circuitNumber;

    @FXML
    private TableColumn<?, ?> dimmer;

    @FXML
    private TableColumn<?, ?> channel;

    @FXML
    private TableColumn<?, ?> position;

    @FXML
    private TableColumn<?, ?> wattage;

    @FXML
    private TableColumn<?, ?> purpose;


//Default Table View

    @FXML
    private TableView<DefaultTableInput> defaultTable;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultFocus;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultAccessories;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultInstrumentType;

    @FXML
    private TableColumn<DefaultTableInput, Integer> defaultAddress;

    @FXML
    private TableColumn<DefaultTableInput, Integer> defaultUnitNumber;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultTemplate2;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultTemplate1;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultColor;

    @FXML
    private TableColumn<DefaultTableInput, Integer> defaultDimmer;

    @FXML
    private TableColumn<DefaultTableInput, Integer> defaultChannel;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultPosition;

    @FXML
    private TableColumn<DefaultTableInput, Integer> defaultWattage;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultPurpose;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultUser1;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultUser2;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultUser3;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultUser4;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultUser5;

    @FXML
    private TableColumn<DefaultTableInput, String> defaultUser6;


    @FXML
    void buttonClicked(ActionEvent event) {
        System.out.println("Button Clicked");
    }


    // File Menu Bar
    // File Menu Bar
    // File Menu Bar
    // File Menu Bar
    @FXML
    void menuItemImport(ActionEvent event) {
//		System.out.println("Import Test");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import XML");

        //Set extension filter for .xml
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML Files (*.xml)", "*.xml");    // Set Extension
        fileChooser.getExtensionFilters().add(extFilter);
        try {
            File selectedFile = fileChooser.showOpenDialog(null);                                               //Created File + fileChooser and shows OpenDialog
            Unmarshaller.runUnmarshaller(selectedFile.getAbsolutePath());                                               //Sends Selected file's absolute path to Unmarshaller
            Unmarshaller.chooseUIDElement(0);                                                              //Prints an element *for testing*
            System.out.println(selectedFile.getAbsolutePath());            //Test

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void menuItemOpen(ActionEvent event) {
//		System.out.println("Import Test");							//Testing onAction functionality

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ALD files (*.ald)", "*.ald");  //Extension filters for .ald
        fileChooser.getExtensionFilters().add(extFilter);

        try {
            File selectedFile = fileChooser.showOpenDialog(null);
            inputPathText = selectedFile.getAbsolutePath();
//			System.out.println(inputPathText);

//			if(selectedFile != null) {
//				System.out.println("Empty");
//			}

            if (extFilter == new FileChooser.ExtensionFilter("ALD files (*.ald)", "*.ald")) {                // Check for correct file type
                System.out.println("Wrong file type");
            }

            PersistantData.deSerialize(selectedFile.getAbsolutePath());                                                    //Static method in the RootData class that "opens" the selected .ald file and sysouts its contents.
        } catch (Exception e) {
            e.printStackTrace();
        }//End of Try-Catch block
    }

    @FXML
    private PrintController printController;

    @FXML
    void menuItemPreferences(ActionEvent event) {
        PrintController prt = new PrintController();
//        Parent popUp;


//            Scene popPreferences = new Scene(this);
//            Stage popUpStage = new Stage();
//            popUpStage.setScene(popPreferences);
//            popUpStage.setTitle("Preferences");
//            popUpStage.show();

//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();

    }

    @FXML
    void menuItemPrint(ActionEvent event) {
        Parent popUp;
        try {
            popUp = FXMLLoader.load(getClass().getResource("FXMLFiles/Print.fxml"));                                //Loader for FXML file, specifically printing
            Scene popPrint = new Scene(popUp);
            Stage popUpStage = new Stage();

            popUpStage.setScene(popPrint);
            popUpStage.setTitle("Print");
            popUpStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }// End of Try-Catch block
    }

    @FXML
    void menuItemQuit(ActionEvent event) {
//		System.out.println("Test");
        Platform.exit();
    }

    @FXML
    void menuItemSaveAs(ActionEvent event) {
        //		System.out.println("Import Test");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("Untitled.ald");
        fileChooser.setTitle("Save As");

        //Set extension filter for .ald files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ALD files (*.ald)", "*.ald"); //Used to specify file extensions
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog

        try {
            File file = fileChooser.showSaveDialog(null);                                                        //Save File Dialog box
            inputNameText = file.getName();                                                                             //Stores the name of the file given by the user into *inputNameText* to be retrieved in the RootData class and stored in the file

            if (file != null) {
                PersistantData.serialize(file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Default table view


    ObservableList<DefaultTableInput> defaultList = FXCollections.observableArrayList(
            new DefaultTableInput(Unmarshaller.chooseUIDElement(0).get(7).toString(), "Template", "Source 4", 14, 1,
                    "Template 2", "Template 1", "Color", 123, 40, "2nd Electric",
                    750, "Purpose", "User1", "User2", "User3",
                    "User4", "User5", "User6"),
            new DefaultTableInput("DownStageRight", "Template", "Source 4", 14, 1,
                    "Template 2", "Template 1", "Color", 123, 40, "2nd Electric",
                    750, "Purpose", "User1", "User2", "User3",
                    "User4", "User5", "User6")
    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        {

            defaultFocus.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultFocus"));
            defaultAccessories.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultAccessories"));
            defaultInstrumentType.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultInstrumentType"));
            defaultAddress.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, Integer>("defaultAddress"));
            defaultUnitNumber.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, Integer>("defaultUnitNumber"));
            defaultTemplate2.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultTemplate2"));
            defaultTemplate1.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultTemplate1"));
            defaultColor.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultColor"));
            defaultWattage.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, Integer>("defaultWattage"));
            defaultDimmer.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, Integer>("defaultDimmer"));
            defaultChannel.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, Integer>("defaultChannel"));
            defaultPosition.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultPosition"));
            defaultPurpose.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultPurpose"));


            defaultUser1.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultUserField1"));
            defaultUser2.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultUserField2"));
            defaultUser3.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultUserField3"));
            defaultUser4.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultUserField4"));
            defaultUser5.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultUserField5"));
            defaultUser6.setCellValueFactory(new PropertyValueFactory<DefaultTableInput, String>("defaultUserField6"));

            defaultTable.setItems(defaultList);
        }
    }


// Getters and Setters for the DefaultTableView. Will add others @ later date


    public TableView<DefaultTableInput> getDefaultTable() {
        return defaultTable;
    }

    public void setDefaultTable(TableView<DefaultTableInput> defaultTable) {
        this.defaultTable = defaultTable;
    }

    public TableColumn<DefaultTableInput, String> getDefaultFocus() {
        return defaultFocus;
    }

    public void setDefaultFocus(TableColumn<DefaultTableInput, String> defaultFocus) {
        this.defaultFocus = defaultFocus;
    }

    public TableColumn<DefaultTableInput, String> getDefaultAccessories() {
        return defaultAccessories;
    }

    public void setDefaultAccessories(TableColumn<DefaultTableInput, String> defaultAccessories) {
        this.defaultAccessories = defaultAccessories;
    }

    public TableColumn<DefaultTableInput, String> getDefaultInstrumentType() {
        return defaultInstrumentType;
    }

    public void setDefaultInstrumentType(TableColumn<DefaultTableInput, String> defaultInstrumentType) {
        this.defaultInstrumentType = defaultInstrumentType;
    }

    public TableColumn<DefaultTableInput, Integer> getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(TableColumn<DefaultTableInput, Integer> defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public TableColumn<DefaultTableInput, Integer> getDefaultUnitNumber() {
        return defaultUnitNumber;
    }

    public void setDefaultUnitNumber(TableColumn<DefaultTableInput, Integer> defaultUnitNumber) {
        this.defaultUnitNumber = defaultUnitNumber;
    }

    public TableColumn<DefaultTableInput, String> getDefaultTemplate2() {
        return defaultTemplate2;
    }

    public void setDefaultTemplate2(TableColumn<DefaultTableInput, String> defaultTemplate2) {
        this.defaultTemplate2 = defaultTemplate2;
    }

    public TableColumn<DefaultTableInput, String> getDefaultTemplate1() {
        return defaultTemplate1;
    }

    public void setDefaultTemplate1(TableColumn<DefaultTableInput, String> defaultTemplate1) {
        this.defaultTemplate1 = defaultTemplate1;
    }

    public TableColumn<DefaultTableInput, String> getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(TableColumn<DefaultTableInput, String> defaultColor) {
        this.defaultColor = defaultColor;
    }

    public TableColumn<DefaultTableInput, Integer> getDefaultDimmer() {
        return defaultDimmer;
    }

    public void setDefaultDimmer(TableColumn<DefaultTableInput, Integer> defaultDimmer) {
        this.defaultDimmer = defaultDimmer;
    }

    public TableColumn<DefaultTableInput, Integer> getDefaultChannel() {
        return defaultChannel;
    }

    public void setDefaultChannel(TableColumn<DefaultTableInput, Integer> defaultChannel) {
        this.defaultChannel = defaultChannel;
    }

    public TableColumn<DefaultTableInput, String> getDefaultPosition() {
        return defaultPosition;
    }

    public void setDefaultPosition(TableColumn<DefaultTableInput, String> defaultPosition) {
        this.defaultPosition = defaultPosition;
    }

    public TableColumn<DefaultTableInput, Integer> getDefaultWattage() {
        return defaultWattage;
    }

    public void setDefaultWattage(TableColumn<DefaultTableInput, Integer> defaultWattage) {
        this.defaultWattage = defaultWattage;
    }

    public TableColumn<DefaultTableInput, String> getDefaultPurpose() {
        return defaultPurpose;
    }

    public void setDefaultPurpose(TableColumn<DefaultTableInput, String> defaultPurpose) {
        this.defaultPurpose = defaultPurpose;
    }

    public TableColumn<DefaultTableInput, String> getDefaultUser1() {
        return defaultUser1;
    }

    public void setDefaultUser1(TableColumn<DefaultTableInput, String> defaultUser1) {
        this.defaultUser1 = defaultUser1;
    }

    public TableColumn<DefaultTableInput, String> getDefaultUser2() {
        return defaultUser2;
    }

    public void setDefaultUser2(TableColumn<DefaultTableInput, String> defaultUser2) {
        this.defaultUser2 = defaultUser2;
    }

    public TableColumn<DefaultTableInput, String> getDefaultUser3() {
        return defaultUser3;
    }

    public void setDefaultUser3(TableColumn<DefaultTableInput, String> defaultUser3) {
        this.defaultUser3 = defaultUser3;
    }

    public TableColumn<DefaultTableInput, String> getDefaultUser4() {
        return defaultUser4;
    }

    public void setDefaultUser4(TableColumn<DefaultTableInput, String> defaultUser4) {
        this.defaultUser4 = defaultUser4;
    }

    public TableColumn<DefaultTableInput, String> getDefaultUser5() {
        return defaultUser5;
    }

    public void setDefaultUser5(TableColumn<DefaultTableInput, String> defaultUser5) {
        this.defaultUser5 = defaultUser5;
    }

    public TableColumn<DefaultTableInput, String> getDefaultUser6() {
        return defaultUser6;
    }

    public void setDefaultUser6(TableColumn<DefaultTableInput, String> defaultUser6) {
        this.defaultUser6 = defaultUser6;
    }
}
