package pl.put.cms.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.put.cms.server.entities.cms.*;
import pl.put.cms.server.entities.restaurant.Category;
import pl.put.cms.server.entities.restaurant.MenuPosition;
import pl.put.cms.server.entities.restaurant.Restaurant;
import pl.put.cms.server.entities.restaurant.RestaurantLocation;
import pl.put.cms.server.repositories.cms.*;
import pl.put.cms.server.repositories.restaurant.*;

import java.util.Arrays;
import java.util.List;


@Component
public class Initial {

    private final AdministratorRepository administratorRepository;
    private final CMSRepository cmsRepository;
    private final NavigationBarRepository navigationBarRepository;
    private final NavigationBarButtonRepository navigationBarButtonRepository;
    private final PostRepository postRepository;
    private final SliderImageRepository sliderImageRepository;
    private final CategoryRepository categoryRepository;
    private final ContactAddressRepository contactAddressRepository;
    private final MenuPositionsRepository menuPositionsRepository;
    private final MenuPositionPicturesRepository menuPositionPicturesRepository;
    private final RestaurantLocationRepository restaurantLocationRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public Initial(AdministratorRepository administratorRepository, CMSRepository cmsRepository, NavigationBarRepository navigationBarRepository, NavigationBarButtonRepository navigationBarButtonRepository, PostRepository postRepository, SliderImageRepository sliderImageRepository, CategoryRepository categoryRepository, ContactAddressRepository contactAddressRepository, MenuPositionsRepository menuPositionsRepository, MenuPositionPicturesRepository menuPositionPicturesRepository, RestaurantLocationRepository restaurantLocationRepository, RestaurantRepository restaurantRepository) {
        this.administratorRepository = administratorRepository;
        this.cmsRepository = cmsRepository;
        this.navigationBarRepository = navigationBarRepository;
        this.navigationBarButtonRepository = navigationBarButtonRepository;
        this.postRepository = postRepository;
        this.sliderImageRepository = sliderImageRepository;
        this.categoryRepository = categoryRepository;
        this.contactAddressRepository = contactAddressRepository;
        this.menuPositionsRepository = menuPositionsRepository;
        this.menuPositionPicturesRepository = menuPositionPicturesRepository;
        this.restaurantLocationRepository = restaurantLocationRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        Administrator administrator = Administrator.builder().login("admin").password("admin".toCharArray()).build();
        administratorRepository.save(administrator);

        Restaurant restaurant = Restaurant.builder()
                .name("Testowa resturacja")
                .cuisine("Smaczna")
                .build();
        restaurantRepository.save(restaurant);

        NavigationBar navigationBar = NavigationBar.builder()
                .logo("")
                .name("Testowa restauracja")
                .build();
        navigationBarRepository.save(navigationBar);
        addNaviButtons(navigationBar);


        CMS cms = CMS.builder()
                .administrator(administrator)
                .navigationBar(navigationBar)
                .restaurant(restaurant)
                .build();
        cmsRepository.save(cms);
        addPosts(cms);

        addRestaurantInfo(restaurant);

    }

    private void addRestaurantInfo(Restaurant restaurant) {
        addRestaurantLocations(restaurant);
        addCategories(restaurant);
    }

    private void addCategories(Restaurant restaurant) {
        List<Category> categories =
                Arrays.asList(
                        Category.builder().category("Pizza").restaurant(restaurant).build(),
                        Category.builder().category("Pasta").restaurant(restaurant).build(),
                        Category.builder().category("Drinks").restaurant(restaurant).build()
                );
        categoryRepository.saveAll(categories);
        addMenuPositions(categories);
    }

    private void addMenuPositions(List<Category> categories) {
        menuPositionsRepository.saveAll(
                Arrays.asList(
                        MenuPosition.builder().name("Pizza 1").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(0)).build(),
                        MenuPosition.builder().name("Pizza 2").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(0)).build(),
                        MenuPosition.builder().name("Pizza 3").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(0)).build(),
                        MenuPosition.builder().name("Pasta 1").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(1)).build(),
                        MenuPosition.builder().name("Pasta 2").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(1)).build(),
                        MenuPosition.builder().name("Pasta 3").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(1)).build(),
                        MenuPosition.builder().name("Drink 1").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(2)).build(),
                        MenuPosition.builder().name("Drink 2").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(2)).build(),
                        MenuPosition.builder().name("Drink 3").description("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia").price(15.1).category(categories.get(2)).build()
                )
        );
    }

    private void addRestaurantLocations(Restaurant restaurant) {
        restaurantLocationRepository.saveAll(
                Arrays.asList(
                        RestaurantLocation.builder().address("Bananowa 3, Poznan").openCloseHours("12:00 - 22:00").restaurant(restaurant).build(),
                        RestaurantLocation.builder().address("Bananowa 10, Wroclaw").openCloseHours("13:00 - 24:00").restaurant(restaurant).build()
                )
        );
    }

    private void addPosts(CMS cms) {
        postRepository.saveAll(
            Arrays.asList(
                    Post.builder().title("Location").text("Thanks for stopping by. We are the last authentic Italian restaurant in Milan, serving delicious Italian cuisine cooked by the best chefs. It only takes a few minutes to browse through our website and check out our menu. We hope you'll soon join us for a superb Italian culinary experience.").img("").cms(cms).build(),
                    Post.builder().title("Location").text("Thanks for stopping by. We are the last authentic Italian restaurant in Milan, serving delicious Italian cuisine cooked by the best chefs. It only takes a few minutes to browse through our website and check out our menu. We hope you'll soon join us for a superb Italian culinary experience.").img("").cms(cms).build()
                    )
        );
    }

    private void addNaviButtons(NavigationBar navigationBar) {
        navigationBarButtonRepository.saveAll(
                Arrays.asList(
                        NavigationBarButton.builder().content("Welcome").url("#Welcome").navigationBar(navigationBar).build(),
                        NavigationBarButton.builder().content("Restaurant").url("#Restaurant").navigationBar(navigationBar).build(),
                        NavigationBarButton.builder().content("Menu").url("#Menu").navigationBar(navigationBar).build(),
                        NavigationBarButton.builder().content("Reservation").url("#Reservation").navigationBar(navigationBar).build(),
                        NavigationBarButton.builder().content("Our Location").url("#OurLocation").navigationBar(navigationBar).build()
                )
        );
    }


}
