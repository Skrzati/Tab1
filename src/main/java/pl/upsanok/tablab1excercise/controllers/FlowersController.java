//package pl.upsanok.tablab1excercise.controllers;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pl.upsanok.tablab1excercise.controllers.dto.Flower;
//
//@RestController()
//@CrossOrigin(origins = {"http://localhost:3000", "https://tab-front-production.up.railway.app"})
//public class FlowersController {
//    Map<String,String> user =  new HashMap<>();
//
//  private String favFlower = "Narcyz";
//
//  @GetMapping("flowers")
//  public ResponseEntity<List<Flower>> getName() {
//    return ResponseEntity.ok(
//        List.of(
//            Flower.builder()
//                .name("Narcyz")
//                .build(),
//            Flower.builder()
//                .name("Roza")
//                .build(),
//            Flower.builder()
//                .name("Hiacynt")
//                .build(),
//            Flower.builder()
//                .name("Przebisnieg")
//                .build(),Flower.builder()
//                .name("Tulipan")
//                .build()
//        ));
//  }
//
//  @GetMapping("flowers/fav/users/{userName}")
//  public ResponseEntity<Flower> getFav(
//          @PathVariable String userName
//  ) {
//      var users =  user.get(userName);
//    return ResponseEntity.ok(
//            Flower.builder()
//                .name(users)
//                .build());
//  }
//
//  @PostMapping("flowers/fav/users/{userName}")
//  public ResponseEntity<Flower> setNewFav(
//      @RequestBody Flower flower,
//      @PathVariable String userName
//  ) {
//      user.put(userName, flower.name());
//    this.favFlower = flower.name();
//    return ResponseEntity.ok(
//        Flower.builder()
//            .build()
//    );
//  }
//}
