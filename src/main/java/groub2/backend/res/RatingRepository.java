/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package groub2.backend.res;

import groub2.backend.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ann
 */
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    
}
