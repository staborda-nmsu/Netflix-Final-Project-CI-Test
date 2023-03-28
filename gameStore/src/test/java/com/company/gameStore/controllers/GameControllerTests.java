package com.company.gameStore.controllers;

import com.company.gameStore.models.Game;
import com.company.gameStore.repositories.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTests {

    @MockBean
    GameRepository gameRepo;
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of records for testing purposes
    private List<Game> gameList;

    // Testing GET /records
    @Test
    public void shouldReturnAllGames() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(gameList);

        // ACT
        mockMvc.perform(get("/games"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing POST /records
    @Test
    public void shouldReturnNewGameOnPostRequest() throws Exception {

        // ARRANGE
        Game inputGame = new Game("Minecraft", "E",
                "Minecraft is a game", 7.25, "Mojang");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputGame);

        Game outputGame = new Game("Minecraft", "E",
                "Minecraft is a game", 7.25, "Mojang");

        String outputJson = mapper.writeValueAsString(outputGame);

        // ACT
        mockMvc.perform(
                        post("/games")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // Testing GET record/{id}
    @Test
    public void shouldReturnGameByStudio() throws Exception {

        Game outputGame = new Game("Minecraft", "E",
                "Minecraft is a game", 7.25, "Mojang");

        doReturn(outputGame).when(gameRepo).save(outputGame);
        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("/games/studio/Mojang"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnGameByESRB() throws Exception {

        Game outputGame = new Game("Minecraft", "E",
                "Minecraft is a game", 7.25, "Mojang");

        doReturn(outputGame).when(gameRepo).save(outputGame);
        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("/games/esrb/E"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnGameByTitle() throws Exception {

        Game outputGame = new Game("Minecraft", "E",
                "Minecraft is a game", 7.25, "Mojang");

        doReturn(outputGame).when(gameRepo).save(outputGame);
        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("/games/title/Minecraft"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing PUT /records/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Game inputGame = new Game("Minecraft", "E",
                "Minecraft is a game", 7.25, "Mojang");

        String inputJson = mapper.writeValueAsString(inputGame);

        mockMvc.perform(
                        put("/games")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing DELETE /records/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/games/0"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
