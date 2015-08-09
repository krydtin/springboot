package com.krydtin.training.springboot.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krydtin.training.springboot.Application;
import com.krydtin.training.springboot.dto.Comment;
import com.krydtin.training.springboot.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author krydtin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class HomeRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private HomeRestController homeRestController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    public HomeRestControllerTest() {
    }

    private List<Comment> getMockedComments() {
        List<Comment> mockedComments = new ArrayList<>();
        Comment mockComment = new Comment();
        mockComment.setAuthor("Max");
        mockComment.setComment("My Comment");
        mockedComments.add(mockComment);
        return mockedComments;
    }

    @Test
    public void testHome() throws Exception {
        final CommentRepository mockedCommentRepository = Mockito.mock(CommentRepository.class);

        Mockito.when(mockedCommentRepository.findAll()).thenReturn(getMockedComments());

        ReflectionTestUtils.setField(homeRestController, "commentRepository", mockedCommentRepository);

        final String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/api"))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
        final ObjectMapper om = new ObjectMapper();
        final List<Comment> comments = om.readValue(contentAsString, new TypeReference<List<Comment>>() {
        });
        for (Comment comment : comments) {
            System.out.println(comment.getAuthor());
            System.out.println(comment.getComment());
        }
    }
}
