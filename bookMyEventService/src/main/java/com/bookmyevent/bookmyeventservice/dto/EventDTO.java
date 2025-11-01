package com.bookmyevent.bookmyeventservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String venue;
    private String city;
    private String address;
    private LocalDateTime eventDateTime;

}