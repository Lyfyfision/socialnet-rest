package pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;
}
