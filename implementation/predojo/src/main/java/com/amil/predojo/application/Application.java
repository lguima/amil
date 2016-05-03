/**
 * 
 */
package com.amil.predojo.application;

import static com.amil.predojo.dao.ImplementationDAO.MATCH;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.dao.factory.AbstractDAOFactory;
import com.amil.predojo.dao.factory.DAOFactory;
import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.award.Award;
import com.amil.predojo.entity.ranking.RankingPlayer;
import com.amil.predojo.entity.ranking.impl.MatchRanking;
import com.amil.predojo.factory.Factory;
import com.amil.predojo.factory.exception.FactoryCreationException;
import com.amil.predojo.file.dao.factory.FileDAOFactory;

/**
 * @author Juliano Sena
 *
 */
public class Application {

	public static final Logger LOGGER = Logger.getLogger(Application.class);

	public static void main(String...args) throws InterruptedException {
		try {
			Factory<DAOFactory> factory = new AbstractDAOFactory();
			FileDAOFactory daoFactory = (FileDAOFactory) factory.create();
			DAO dao = daoFactory.create(MATCH, "data/matchs.log");

			Collection<Match> matchCollection = dao.findAll();

			File file = new File("data/match-raking.csv");
			FileWriter fw = new FileWriter(file, false);

			for(Match match : matchCollection){
				fw.write("Jogador;Quantidade de assassinatos;Quantidade de mortes;Prêmios\r");
				MatchRanking matchRanking = new MatchRanking(match);
				Collection<RankingPlayer> rankingPlayerCollection = matchRanking.rankear();
				for(RankingPlayer rankingPlayer : rankingPlayerCollection){
					fw.write(rankingPlayer.getPlayer().toString() + ";");
					fw.write(rankingPlayer.getTotalMurders().toString() + ";");
					fw.write(rankingPlayer.getTotalDeaths().toString() + ";");
					StringBuilder awardsBuilder = new StringBuilder();
					for(Award award : rankingPlayer.getAwardsCollection()){
						awardsBuilder.append(award.toString() + ",");
					}
					fw.write(awardsBuilder.toString()+"\r");
				}
				fw.write("\r");
				fw.write(
						String.format("Vencedor é: %s e sua arma preferida é %s",
								matchRanking.winner().toString(),
								matchRanking.winner().prefferedWeapon()
						)
				);
				fw.write("\r");
				fw.write(
						String.format("A maior sequência de assassinato sem morrer foi feita por %s, matou %s sem morrer",
								matchRanking.mostMurderSequenceWithoutDie().player().toString(),
								matchRanking.mostMurderSequenceWithoutDie().sequence().toString()
						)
				);
				fw.write("\r\r\r");
			}
			fw.close();
			
		} catch (Exception e) {
			System.out.println("Problemas na aplicação, visualize o log por favor!");
			LOGGER.error(e.getMessage(), e);
		}

		Thread.sleep(2000);
		System.exit(0);
	}

}
