package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.repository.OrderRepository;
import com.mycompany.myapp.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DatabasePopulator {

    public static final int NB_PRODUCT = 8;
    public static final int NB_ORDER = 30;
    public static final int NB_PRODUCT_WITHOUT_ORDER = 2;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    boolean populate = false;

    public void populate() {
        if (populate) return;
        final List<Product> products = createProducts(NB_PRODUCT);
        productRepository.saveAll(products);
        populate = true;
    }

    private List<Product> createProducts(int nbProducts) {
        List<Product> products = new ArrayList<Product>();
        String[][] arrayProduct = {
            {
                "Aroma Rose",
                "2020",
                "Rhône",
                "6.90",
                "13",
                "rosé",
                "10",
                "2",
                "12",
                "apéritif, entrée, viande rouge, viande blanche, volaille, barbecue, fromage",
                "Croyez-nous bien que la version du Arôma en Rosé est une valeur sure à 100% ! Une explosion de fraîcheur ! Le fruité rouge est très aguicheur et cliquant, mais il se fond dans une bouche sexy et fédératrice. Une arme redoutable pour impressionner lors de vos apéritifs, barbecue, pizza party ou soirées sushi... On adore et on en redemande !",
            },
            {
                "Syrah des princes",
                "2019",
                "Rhône",
                "5.99",
                "14.5",
                "rouge",
                "15",
                "2",
                "4",
                "apéritif, charcuterie, viande rouge, volaille, barbecue",
                "On retrouve dans cette cuvée signée du Cellier des Princes toute la typicité de la Syrah mêlée à un climat chaud et sec, et à un terroir de galets roulés, exaltant une trame fraîche et une palette aromatique intense. Notes de cassis et de réglisse en bouche, vous serez assurément conquis par cette touche légèrement poivrée en finale. En somme, une pépite à un prix des plus accessibles !",
            },
            {
                "Premieres Grives",
                "2020",
                "Sud-Ouest",
                "10.5",
                "11.5",
                "blanc",
                "9",
                "2",
                "20",
                "apéritif, foie gras, viande blanche, desserts aux fruits",
                "Les Premières Grives ou le plaisir de se faire plaisir... ! Succès mondial, les  Premières Grives  du Domaine du Tariquet c'est avant tout : une bouche gourmande, fruitée , vive et moelleuse (fruits exotiques, agrumes et raisins frais). C'est un vin qui se glisse entre 2 sensations : celle d'une onctuosité enjôleuse, conjuguée à une profonde fraîcheur. Ce duo moelleux/fraîcheur, qui fonctionne à merveille, lui donne cette originalité si recherchée. Il se boit et se partage en toutes occasions, avec des atouts si redoutables qu'à l'aveugle, on ne peut se douter de son formidable rapport qualité-prix...!",
            },
            {
                "Sirene de Giscours",
                "2016",
                "Bordeaux",
                "35.0",
                "13",
                "rouge",
                "17",
                "24",
                "4",
                "apéritif, viande rouge, viande blanche, volaille, gibier, fromage",
                "Issu de vignes plus jeunes, le second vin du Château Giscours provient cependant des mêmes terroirs et des mêmes cépages que son aîné. Le millésime 2016 présente une belle robe brillante. Le nez dégage de savoureux arômes de fruits rouges et noirs mûrs, des notes boisées, de chocolat. Le vin est rond, gras, long en bouche avec une agréable souplesse des tanins. Un grand second vin toujours aussi harmonieux!",
            },
            {
                "Chateau Giscours",
                "2015",
                "Bordeaux",
                "78.0",
                "14",
                "rouge",
                "17",
                "19",
                "30",
                "viande rouge, viande blanche, volaille, gibier, fromage",
                "Ce Giscours 2015 a un bouquet très raffiné avec des arômes abondants de mûre, de framboise, de silex et de graphite. La bouche est très bien équilibrée avec une grande profondeur et une réelle vivacité. La texture est légèrement crayeuse, extraordinairement fraîche avec une superbe tension minérale sur la longue finale. Un superbe Giscours !",
            },
            {
                "Chateau Giscours",
                "2016",
                "Bordeaux",
                "75.0",
                "13.5",
                "rouge",
                "17",
                "24",
                "3",
                "viande rouge, viande blanche, volaille, gibier, fromage",
                "Le Giscours 2016 est complexe, aromatiquement intense et séduisant, avec une myriade de nuances qui se déploient dans le verre. La cerise noire, la sauge, le cuir, les notes fumées et mentholées ajoutent beaucoup d'intrigue, mais surtout, c'est l'équilibre et cette impression harmonieuse qui en font un vin d' exception. Sous la direction d'Alexander Van Beek et de son équipe, Giscours est sur une lancée de plusieurs millésimes successifs très réussis. Le 2016 est est un autre bel exemple !",
            },
            {
                "Pays d'Oc Tiberius",
                "2019",
                "Languedoc",
                "6.60",
                "12.5",
                "blanc",
                "9",
                "3",
                "30",
                "apéritif, hors d'oeuvre, salade, tartes, poissons",
                "Des arômes raffinés de pêche, agrumes et fruits exotiques. Une bouche vive aux notes acidulées et fruitées. Une finale délicate qui s'associera parfaitement avec une tarte salée ou un poisson grillé.",
            },
            {
                "Merlot et Cabernet Sauvignon",
                "2020",
                "Sud-Ouest",
                "6.80",
                "13",
                "rosé",
                "9",
                "3",
                "12",
                "apéritifs, hors d'oeuvre, salade, charcuterie, tartes, terrines et pâtés, viande blanche",
            },
            //{},
            //{}, {}, {}, {}, {}, {}
        };
        for (int i = 0; i < nbProducts; i++) {
            final Product product = new Product();
            product.setName(arrayProduct[i][0]);
            product.setYear(Integer.parseInt(arrayProduct[i][1]));
            product.setRegion(arrayProduct[i][2]);
            product.setPrice(Float.parseFloat(arrayProduct[i][3]));
            product.setAlcoholPer(Float.parseFloat(arrayProduct[i][4]));
            product.setType(arrayProduct[i][5]);
            product.setTemperature(Integer.parseInt(arrayProduct[i][6]));
            product.setAgeLimit(Integer.parseInt(arrayProduct[i][7]));
            product.setStock(Integer.parseInt(arrayProduct[i][8]));
            product.setRecommandation(arrayProduct[i][9]);
            product.setDescription(arrayProduct[i][10]);
            product.setPercentPromo((float) 1.0);
            products.add(product);
        }
        return products;
    }
}
