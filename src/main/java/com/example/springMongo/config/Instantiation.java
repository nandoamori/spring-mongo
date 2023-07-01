package com.example.springMongo.config;

import com.example.springMongo.domain.Post;
import com.example.springMongo.domain.User;
import com.example.springMongo.dto.AuthorDTO;
import com.example.springMongo.dto.CommentDTO;
import com.example.springMongo.repository.PostRepository;
import com.example.springMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu Roma!", "Vou viajar agora, abraços!", new AuthorDTO(maria) );
        Post post2 = new Post(null, sdf.parse("15/05/2023"), "Feliz demais!", "Dia bom!", new AuthorDTO(alex) );

        CommentDTO c1 = new CommentDTO("Boa viagem mano!!!", sdf.parse("16/05/2023"), new AuthorDTO(alex) );
        CommentDTO c2 = new CommentDTO("Aí sim!!!", sdf.parse("21/06/2023"), new AuthorDTO(bob) );
        CommentDTO c3 = new CommentDTO("Deus abençoe!!!", sdf.parse("14/06/2023"), new AuthorDTO(maria) );

        post1.getComments().addAll(Arrays.asList(c1));
        post2.getComments().addAll(Arrays.asList(c2, c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1));
        userRepository.save(maria);

        alex.getPosts().addAll(Arrays.asList(post2));
        userRepository.save(alex);
    }
}
