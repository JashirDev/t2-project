package com.example.schooladministrator.administrator.model.api;

import com.example.schooladministrator.administrator.model.SchoolData;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolRequest {

  private SchoolData schoolData;

}
