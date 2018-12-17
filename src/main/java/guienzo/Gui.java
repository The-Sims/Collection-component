package guienzo;

import communication.clienthandler.ClientHandler;
import communication.clienthandler.IClientHandler;
import communication.clientmessagegenerator.ClientMessageGenerator;
import communication.clientmessagegenerator.IClientMessageGenerator;
import communication.clientmessagehandlers.ClientMessageHandlerFactory;
import communication.clientmessagehandlers.IMessageHandlerFactory;
import communication.clientmessageprocessor.ClientMessageProcessor;
import communication.clientwebsockets.ClientWebsocket;
import communication.clientwebsockets.IClientWebsocket;
import communication.messageprocessor.IMessageProcessor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logger.LogLevel;
import logger.Logger;
import models.MessageTip;

import java.util.ArrayList;

public class Gui extends Application implements IGui {

    public static void  main(String[] args) {
        launch(args);
    }

    final ObservableList<String> searchTerms = FXCollections.observableArrayList();

    public void start(Stage primaryStage) {

        IClientWebsocket socket = new ClientWebsocket();
        IClientMessageGenerator messageGenerator = new ClientMessageGenerator(socket);
        IMessageHandlerFactory factory = new ClientMessageHandlerFactory();
        IClientHandler clientHandler = new ClientHandler(messageGenerator);
        IMessageProcessor messageProcessor = new ClientMessageProcessor(factory, clientHandler);
        socket.setMessageHandler(messageProcessor);
        socket.start();
        setClientHandler(clientHandler);
        clientHandler.setGui(this);

        // GUI CONTROLS!
        Label originLabel = new Label("Origin:");
        originLabel.setMaxSize(70, 15);
        final TextField originTf = new TextField();
        originTf.setMaxSize(150, 15);

        Label senderLabel = new Label("Sender:");
        senderLabel.setMaxSize(70, 15);
        final TextField senderTf = new TextField();
        senderTf.setMaxSize(150, 15);

        Label messageLabel = new Label("Message:");
        messageLabel.setMaxSize(70,15);
        final TextField messageTf = new TextField();
        messageLabel.setMaxSize(150, 15);

        Label locationLabel = new Label("Location:");
        locationLabel.setMaxSize(70, 15);
        final TextField locationTf = new TextField();
        locationTf.setMaxSize(150, 15);

        Button addBtn = new Button("Add");

        ListView<String> messageTipListView = new ListView<String>();
        messageTipListView.setMaxSize(900, 300);

        messageTipListView.setItems(searchTerms);


        // BUTTON
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (originTf.getText().isEmpty() || senderTf.getText().isEmpty() || messageTf.getText().isEmpty() || locationTf.getText().isEmpty()) {
                    Logger.getInstance().log("You forgot somethings", LogLevel.FATAL);
                }
                else {
                    clientHandler.sendTip(originTf.getText(), senderTf.getText(), messageTf.getText(), locationTf.getText());
                }
            }
        });


        // ADD ALL CONTROLS TO THE SCENE
        Pane root = new Pane();
        root.getChildren().add(originLabel);
        root.getChildren().add(senderLabel);
        root.getChildren().add(messageLabel);
        root.getChildren().add(locationLabel);
        root.getChildren().add(addBtn);
        root.getChildren().add(messageTipListView);
        root.getChildren().add(originTf);
        root.getChildren().add(senderTf);
        root.getChildren().add(messageTf);
        root.getChildren().add(locationTf);

        messageTipListView.setLayoutX(50);
        messageTipListView.setLayoutY(50);
        originLabel.setLayoutX(400);
        originLabel.setLayoutY(50);
        originTf.setLayoutX(450);
        originTf.setLayoutY(50);
        senderLabel.setLayoutX(400);
        senderLabel.setLayoutY(100);
        senderTf.setLayoutX(450);
        senderTf.setLayoutY(100);
        messageLabel.setLayoutX(400);
        messageLabel.setLayoutY(150);
        messageTf.setLayoutX(450);
        messageTf.setLayoutY(150);
        locationLabel.setLayoutX(400);
        locationLabel.setLayoutY(200);
        locationTf.setLayoutX(450);
        locationTf.setLayoutY(200);

        addBtn.setLayoutX(500);
        addBtn.setLayoutY(240);

        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.setTitle("Tip Test GUI");
        primaryStage.show();
    }

    IClientHandler handler;

    @Override
    public void setClientHandler(IClientHandler clientHandler){
        this.handler = clientHandler;
    }

    public void setSearchTerms(ArrayList<String> terms) {
        searchTerms.addAll(terms);
    }

    public void updateSearchTerms(String term, boolean add){
        if (add){
            searchTerms.add(term);
        }
        else{
            for(String s: searchTerms){
                if (s.equals(term)){
                    searchTerms.remove(s);
                    break;
                }
            }
        }
    }
}
