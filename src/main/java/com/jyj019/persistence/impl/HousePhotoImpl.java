package com.jyj019.persistence.impl;

import org.springframework.stereotype.Repository;

import com.jyj019.domain.HousePhoto;
import com.jyj019.persistence.HousePhotoDao;

@Repository
public class HousePhotoImpl extends BaseDaoAdapter<HousePhoto, Integer> implements HousePhotoDao {

}
