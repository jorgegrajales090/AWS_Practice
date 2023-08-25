package com.lambdapractica;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Map;

public class MusicaHandler implements RequestHandler<Map<String, String>, ArrayList<Musica>> {

    private AmazonDynamoDB amazonDynamoDB;

    private String DYNAMODB_TABLE_NAME = "Musica";
    private Regions REGION = Regions.US_EAST_2;

    @Override
    public ArrayList<Musica> handleRequest(Map<String, String> stringStringMap, Context context) {

        this.amazonDynamoDB = this.initDynamoDbClient();
        DynamoDB dynamoDB = new DynamoDB(this.amazonDynamoDB);

        Table musicaTable = dynamoDB.getTable(DYNAMODB_TABLE_NAME);

        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey("artista", "Ruben Blades",
                        "cancion", "Plastico");

        Item item = musicaTable.getItem(spec);

        ArrayList<Musica> musicaResult = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        if(item != null)
        {
            try {
                Musica musicaItemFromDynamo = mapper.readValue(item.toJSON(), Musica.class);

                musicaResult.add(musicaItemFromDynamo);

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }

        return musicaResult;
    }

    private AmazonDynamoDB initDynamoDbClient() {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();
    }
}
