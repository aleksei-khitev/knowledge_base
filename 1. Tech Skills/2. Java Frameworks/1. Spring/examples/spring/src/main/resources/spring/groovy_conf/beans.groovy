import ru.akhitev.kb.spring.groovy_conf.Player
import ru.akhitev.kb.spring.groovy_conf.Roster

beans {
    endemeon(Player, name: "Endemeon", level: 170)
    emeon(Player, name: "Emeon", level: 45)
    myCharacters(Roster, players: [endemeon, emeon])
}