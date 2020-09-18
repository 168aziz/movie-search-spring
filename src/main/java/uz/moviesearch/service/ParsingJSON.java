package uz.moviesearch.service;

import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import uz.moviesearch.models.*;

import java.util.*;

@Service
@Scope("prototype")
public class ParsingJSON {


    private List<Scene> popular;

    private static Logger logger;



//
//    private static AbstractMovie parseAbstractMovieInfo(JSONObject obj, String path, AbstractMovie movie) {
//
//        movie.setGenres(parseGenres(obj.getJSONArray("genres")));
//        movie.setBackdrop_path(obj.optString("backdrop_path"));
//        movie.setHomepage(obj.optString("homepage"));
//        movie.setId(obj.getInt("id"));
//        movie.setOriginal_title(obj.optString("original_title"));
//        movie.setOverview(obj.optString("overview"));
//        movie.setPopularity(obj.optDouble("popularity"));
//        movie.setPoster_path(obj.optString("poster_path"));
//        movie.setStatus(obj.optString("status"));
//        movie.setVote_average(obj.optString("vote_average"));
//        movie.setTagline(obj.optString("tagline"));
//        movie.setOriginal_language(obj.getString("original_language"));
//
//        movie.setImages(getImages(path));
//        movie.setVideos(getVideos(path));
//        movie.setCredits(getCredits(path));
//        movie.setRecommendations(getRecommendations(path));
//        movie.setExternal_ids(getExternalIds(path));
//
//        return movie;
//    }
//
//    private static List<Genre> parseGenres(JSONArray array) {
//
//        List<Genre> genres = new ArrayList<>();
//
//        array.forEach(gnr -> {
//            JSONObject obj = new JSONObject(valueOf(gnr));
//            Genre genre = new Genre();
//            genre.setId(obj.getInt("id"));
//            genre.setName(obj.getString("name"));
//            genres.add(genre);
//        });
//
//        return genres;
//    }
//
//    private static Map<String, Object> getExternalIds(String path) {
//        URL url = builder(path + "/external_ids", null);
//        Optional<String> read = read(url);
//        return read.map(str -> new JSONObject(str).toMap()).orElse(null);
//    }
//
//
//    private static List<String> getVideos(String path) {
//        URL url_ru = builder(path + "/videos", ImmutableList.of(new BasicNameValuePair("language", language)));
//        URL url_en = builder(path + "/videos", ImmutableList.of(new BasicNameValuePair("language", "en-US")));
//
//        Optional<String> read_ru = read(url_ru);
//        Optional<String> read_en = read(url_en);
//
//        List<String> videos = new ArrayList<>();
//
//        read_en.ifPresent(v -> videos.addAll(parseVideos(new JSONObject(v).getJSONArray("results"))));
//        read_ru.ifPresent(v -> videos.addAll(parseVideos(new JSONObject(v).getJSONArray("results"))));
//
//        return ImmutableList.copyOf(videos);
//    }
//
//    private static List<String> parseVideos(JSONArray results) {
//        List<String> videos = new ArrayList<>();
//        results.forEach(video -> {
//            JSONObject obj = new JSONObject(valueOf(video));
//            if (obj.optString("site").equals("YouTube")) {
//                videos.add(obj.getString("key"));
//            }
//        });
//        return videos;
//    }
//
//    private static List<String> parseImages(JSONArray results) {
//        List<String> images = new ArrayList<>();
//        results.forEach(image -> images.add(new JSONObject(valueOf(image)).getString("file_path")));
//        return images;
//    }
//
//    private static List<String> getImages(String path) {
//        URL url = builder(path + "/images", null);
//
//        Optional<String> read = read(url);
//
//        return read.map(str -> ImmutableList.copyOf(parseImages(new JSONObject(str).getJSONArray("backdrops")))).orElse(null);
//    }
//
//    public static List<Person> getCredits(String path) {
//        URL url = builder(path + "/credits", ImmutableList.of(new BasicNameValuePair("language", language)));
//
//        Optional<String> read = read(url);
//
//        return read.map(str -> {
//            JSONArray cast = new JSONObject(str).getJSONArray("cast");
//            List<Person> credits = new ArrayList<>();
//
//            cast.forEach(crdt -> {
//
//                JSONObject obj = new JSONObject(valueOf(crdt));
//
//                Credits credit = new Credits();
//                credit.setCast_id(obj.optInt("cast_id"));
//                credit.setCredit_id(obj.optInt("credit_id"));
//                credit.setId(obj.getInt("id"));
//                credit.setName(obj.getString("name"));
//                credit.setCharacter(obj.optString("character"));
//                credit.setProfile_path(obj.optString("profile_path"));
//                credits.add(credit);
//            });
//            return credits;
//        }).orElse(null);
//    }
//
//    private static List<AbstractMovie> getRecommendations(String path) {
//        URL url = builder(path + "/recommendations", ImmutableList.of(new BasicNameValuePair("language", language)));
//
//        Optional<String> read = read(url);
//
//        return read.map(str -> parseAbstractMovie(new JSONObject(str).getJSONArray("results"), -1)).orElse(null);
//    }
//
//    public static Optional<Person> getPersonInfo(int person_id) {
//        String path = "/person/" + person_id;
//        URL url = builder(path, ImmutableList.of(new BasicNameValuePair("language", language)));
//
//        Optional<String> read = read(url);
//
//        return read.map(str -> {
//            JSONObject obj = new JSONObject(str);
//            Person person = new Person();
//
//            person.setBirthday(LocalDate.parse(obj.optString("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            person.setKnown_for_department(obj.optString("known_for_department"));
//            person.setDeathday(obj.optString("deathday").isEmpty() ? null : LocalDate.parse(obj.optString("deathday"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            person.setId(obj.optInt("id"));
//            person.setGender(obj.optInt("gender") == 1 ? "Женский" : "Мужской");
//            person.setBiography(obj.optString("biography"));
//            person.setPopularity(obj.optDouble("popularity"));
//            person.setPlace_of_birth(obj.optString("place_of_birth"));
//            person.setProfile_path(obj.optString("profile_path"));
//            person.setImdb_id(obj.optString("imdb_id"));
//            person.setHomepage(obj.optString("homepage"));
//            List<String> aka = new ArrayList<>();
//            obj.optJSONArray("also_known_as").forEach(item -> aka.add(valueOf(item)));
//            person.setAlso_known_as(aka);
//            person.setExternal_ids(getExternalIds(path));
//            person.setMovieList(getMovies(path));
//            return person;
//        });
//    }
//
//    private static Map<String, AbstractMovie> getMovies(String path) {
//        URL url = builder(path + "/combined_credits", ImmutableList.of(new BasicNameValuePair("language", language)));
//
//        Optional<String> read = read(url);
//
//        return read.map(str -> {
//            Map<String, AbstractMovie> map = new HashMap<>();
//            new JSONObject(str).getJSONArray("cast").forEach(castItem -> {
//                JSONObject obj = new JSONObject(valueOf(castItem));
//                AbstractMovie movie = null;
//                String media_type = obj.getString("media_type");
//                if (media_type.equals("movie")) {
//                    movie = new Movie();
//                    movie.setTitle(obj.optString("title"));
//                    movie.setOriginal_title(obj.optString("original_title"));
//                } else if (media_type.equals("tv")) {
//                    movie = new TVShow();
//                    movie.setTitle(obj.optString("name"));
//                }
//
//                if (movie != null) {
//                    movie.setId(obj.getInt("id"));
//                    movie.setPoster_path(obj.optString("poster_path"));
//                    map.put(media_type+" "+movie.getId(), movie);
//                }
//            });
//            return map;
//        }).orElse(null);
//
//    }
//

}
