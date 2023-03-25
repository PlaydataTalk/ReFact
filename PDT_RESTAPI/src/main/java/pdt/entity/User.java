package pdt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Transactional
@Entity
public class User {

	@Id
	@Column(nullable = false)
	private String userEmail;

	@Column(nullable = false, columnDefinition = "LONGTEXT")
	private String userPassword;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = true)
	private String userImgUrl;

	@Column(nullable = true, columnDefinition = "LONGTEXT")
	private String idToken;

	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private final List<Post> post = new ArrayList<>();

	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private final List<Ilike> ilike = new ArrayList<>();

	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private final List<Reply> reply = new ArrayList<>();

}
