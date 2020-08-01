package com.onCloud.memberService.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.onCloud.memberService.models.Member;
import com.onCloud.memberService.models.Movie;
import com.onCloud.memberService.service.exception.FavMovieNotFoundExpection;
import com.onCloud.memberService.service.impl.MemberService;

/**
 * @author Tajuddin
 *
 */

@RestController
@RequestMapping("/tajuddin")
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	WebClient.Builder webClientBuilder;

	@Autowired
	MemberService memberService;

	/**
	 * @return
	 */
	@GetMapping
	public List<Member> getAllMembers() {
		log.debug("List all Movie details..");
		return memberService.findAllMember();
	}

	/**
	 * @param userId
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Member> getUserById(@PathVariable(value = "id") String userId) {
		return memberService.findById(userId);
	}

	/**
	 * @param member
	 * @return
	 */
	@PostMapping(value = "/createMember")
	public Member createMember(@RequestBody Member member) {
		return memberService.createMember(member);
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteMember/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
		memberService.deleteById(id);
		return null;
	}

	/* Movie Info start */

	/**
	 * @return
	 */
	@GetMapping("/getAllmovies")
	public List<Movie> getAllMovies() {
		System.out.println("List all Movie details..");
		return memberService.findAllMovie();
	}

	
	@GetMapping("/getFavMovies/{id}")
	public List<Movie> getFavMovies(@PathVariable(value = "id") String memberId) throws FavMovieNotFoundExpection {
		return memberService.getMemberFavoriteMovies(memberId);
	}

	/**
	 * @param movie
	 * @return
	 */
	@PostMapping(value = "/createMember")
	public Movie createMember(@RequestBody Movie movie) {
		return memberService.createMovie(movie);
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable("id") String id) {
		memberService.deleteMovieById(id);
		return "Delete Successful";
	}

	/**
	 * @param id
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/updateMember/{id}", method = RequestMethod.PUT)
	public @Valid Member modifyById(@PathVariable("id") String id, @Valid @RequestBody Member member) {
		member.setId(id);
		return memberService.saveMember(member);
	}

	/**
	 * @param id
	 * @param movie
	 * @return
	 */
	@RequestMapping(value = "/updatemovie/{id}", method = RequestMethod.PUT)
	public @Valid Movie updateMovie(@PathVariable("id") String id, @Valid @RequestBody Movie movie) {
		movie.setId(id);
		return memberService.saveMovie(movie);
	}

}
