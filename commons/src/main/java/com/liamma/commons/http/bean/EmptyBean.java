package com.liamma.commons.http.bean;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/19 10:02
 * DESCRIPTION: Represents a null data in response, used when server does not return any data.
 * Do not use this as {@code ResponseEntity<EmptyBean>}, use {@code ResponseEntity<Void>} instead.
 */
@Deprecated
public class EmptyBean {
}
