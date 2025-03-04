package com.ab.atlanta_braves.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(Sort sort) {
        return playerRepository.findAll(sort);
    }

    public List<Player> getPlayersByName(String searchedPlayer, Sort sort){
        return playerRepository.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchedPlayer.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String searchedPosition, Sort sort) {
        return playerRepository.findAll().stream().filter(player -> player.getPosition().toLowerCase().contains(searchedPosition.toLowerCase())).collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setAge(updatedPlayer.getAge());
            playerToUpdate.setPosition(updatedPlayer.getPosition());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }

        return null;
    }

    @Transactional
    void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }

}
