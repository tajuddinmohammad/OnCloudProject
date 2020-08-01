package com.onCloud.memberService.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onCloud.memberService.models.Member;
import com.onCloud.memberService.models.Movie;
import com.onCloud.memberService.repository.MemberRepository;
import com.onCloud.memberService.repository.MovieRepository;
import com.onCloud.memberService.service.exception.FavMovieNotFoundExpection;

@Service
public class MemberService {

	@Autowired(required = true)
	private MemberRepository memberRepository;

	@Autowired(required = true)
	MovieRepository movieRepository;
	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * @return
	 */
	public List<Member> findAllMember() {
		System.out.println("List all Movie details..");
		return memberRepository.findAll();
	}

	/**
	 * @param userId
	 * @return
	 */
	public Optional<Member> findById(String userId) {
		return memberRepository.findById(userId);
	}

	/**
	 * @param member
	 * @return
	 */
	public Member createMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}

	/**
	 * @param id
	 * @return
	 */
	public ResponseEntity<HttpStatus> deleteById(String id) {
		try {
			memberRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}


	/**
	 * @return
	 */
	public List<Member> findBy() {
		System.out.println("List all Movie details..");
		return memberRepository.findAll();
	}

	/**
	 * @param movie
	 * @return
	 */
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	/**
	 * @param id
	 * @return
	 */
	public ResponseEntity<HttpStatus> deleteMovieById(String id) {
		try {
			movieRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	/**
	 * @param member
	 * @return
	 */
	public Member update(Member member) {
		return memberRepository.save(member);
	}

	/**
	 * @param member
	 * @return
	 */
	public @Valid Member saveMember(@Valid Member member) {
		return memberRepository.save(member);

	}

	/**
	 * @param memberId
	 * @return
	 * @throws FavMovieNotFoundExpection
	 */
	public List<Movie> getMemberFavoriteMovies(String memberId) throws FavMovieNotFoundExpection {
		List<Movie> listOfFavMovies = movieRepository.findByMemberAndIsFavoriteTrue(memberId);
		if (listOfFavMovies.isEmpty()) {
			throw new FavMovieNotFoundExpection();
		}

		return listOfFavMovies;
	}

	/**
	 * @return
	 */
	public List<Movie> findAllMovie() {
		log.debug("Getting all movies list");
		return movieRepository.findAll();
	}

	/**
	 * @param movie
	 * @return
	 */
	public Movie saveMovie(@Valid Movie movie) {
		log.debug("updating movie");
		return movieRepository.save(movie);
		
	}

}