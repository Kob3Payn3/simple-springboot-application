package com.ab.atlanta_braves.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/getPlayers")
    public List<Player> getPlayers(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String position,
                                   @RequestParam(defaultValue = "name") String sortBy,
                                   @RequestParam(defaultValue = "asc") String order) {
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        if (sortBy == null) {
            sortBy = "id";
        }

        if (order == null) {
            order = "asc"; // makes the ascending order sort default
        }

        if (name != null) {
            return playerService.getPlayersByName(name, Sort.by(direction, sortBy));
        }
        else if (position != null) {
            return playerService.getPlayersByPosition(position, Sort.by(direction, sortBy));
        }
        return playerService.getPlayers(Sort.by(direction, sortBy));
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = new Player(player.getName(), player.getAge(), player.getPosition());
        Player playerCreated = playerService.addPlayer(player);

        if (playerCreated != null) {
            return new ResponseEntity<>(playerCreated, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player resultPlayer = playerService.updatePlayer(player);
        if (resultPlayer != null) {
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player was deleted.", HttpStatus.OK);
    }
}
