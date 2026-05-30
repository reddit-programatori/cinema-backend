package dev_practice.cinema_backend.domain.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException user(long id) {
        return new NotFoundException("User not found with id: " + id);
    }

    public static NotFoundException comment(long id) {
        return new NotFoundException("Comment not found with id: " + id);
    }

    public static NotFoundException movie(long id) {
        return new NotFoundException("Movie not found with id: " + id);
    }

    public static NotFoundException genre(long id) {
        return new NotFoundException("Genre not found with id: " + id);
    }

}
