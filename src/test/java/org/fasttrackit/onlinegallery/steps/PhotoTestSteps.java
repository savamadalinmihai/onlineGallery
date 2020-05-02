package org.fasttrackit.onlinegallery.steps;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.service.PhotoService;
import org.fasttrackit.onlineGallery.transfer.photo.SavePhotoRequest;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhotoTestSteps {

    private PhotoService photoService;

    public void createPhoto(){
        SavePhotoRequest request = new SavePhotoRequest();
        request.setName("x_pro2_2019_01_12.jpeg");
        request.setCreatedDate(Date.valueOf("2019-12-22"));
        request.setSizeInKb(22512);
        request.setTaggedAsFavorite(false);
        request.setxAxisDimension(6000);
        request.setyAxisDimension(4000);
        request.setUrl("www.siteurl.com");

        Photo photo = photoService.createPhoto(request);

        assertThat(photo, notNullValue());
        assertThat(photo.getId(), greaterThan(0L));
        assertThat(photo.getName(), is(request.getName()));
        assertThat(photo.getCreatedDate(), is(request.getCreatedDate()));
        assertThat(photo.getSizeInKb(), is(request.getSizeInKb()));
        assertThat(photo.isTaggedAsFavorite(), is (request.isTaggedAsFavorite()));
        assertThat(photo.getxAxisDimension(), is(request.getxAxisDimension()));
        assertThat(photo.getyAxisDimension(), is(request.getyAxisDimension()));
        assertThat(photo.getUrl(), is(request.getUrl()));
    }
}
