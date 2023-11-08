package com.example.demo.controller;

import com.example.demo.DTO.*;
import com.example.demo.Entities.dbo.Cart;
import com.example.demo.Entities.sales.CustomCageOrders;
import com.example.demo.Repo.*;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.CartService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@CrossOrigin("http://localhost:3000")
@RequestMapping("/cart")
public class CartController {
  @Autowired CartService service;
  @Autowired CartRepository repository;
  @Autowired RegularCagesRepository regularCagesRepository;
  @Autowired AccountService accservice;
  @Autowired CustomCageOrdersRepository customCageOrdersRepository;
  @Autowired AccountRepo accountRepo;
  @Autowired PaymentRepo paymentRepo;

  @GetMapping(value = {"/get"})
  public ResponseEntity<?> get(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "pageSize", required = false) Integer pageSize,
      @RequestParam(name = "username", required = false) String username,
      @RequestParam(name = "status", required = false, defaultValue = "0") Integer status) {
    if (page == null) page = 1;
    if (pageSize == null) pageSize = 1000;

    //        repository.removeAllOrderCustomize(username);
    Page<CartDTOInterface> objectPage = service.get(username, page, pageSize, status);
    List<CartDTOInterface> list = objectPage.toList();
    List<CardDTO> cardDTOList = new ArrayList<>(); // Initialize a new ArrayList

    for (CartDTOInterface cart : list) {
      if (cart.getProduct_id() != null) {
        CardDTO dto =
            CardDTO.builder()
                .billId(cart.getBill_id())
                .birdtypeId(cart.getBirdtypeId())
                .createdDate(cart.getCreated_date())
                .datePay(cart.getDate_pay())
                .description(cart.getDescription())
                .expectedDate(cart.getExpected_date())
                .NumberOfSelectedItems(cart.getNumberOfSelectedItems()) // Use the setter method
                .price(cart.getPrice())
                .regularCages(
                    regularCagesRepository
                        .getRegularCagesByCageId(cart.getProduct_id())
                        .orElse(null))
                .material(cart.getMaterial())
                .shape(cart.getShape())
                .productId(cart.getProduct_id())
                .status(cart.getStatus())
                .username(cart.getUsername())
                .build();
        cardDTOList.add(dto);
      } else {
        CardDTO dto =
            CardDTO.builder()
                .billId(cart.getBill_id())
                .birdtypeId(cart.getBirdtypeId())
                .createdDate(cart.getCreated_date())
                .datePay(cart.getDate_pay())
                .description(cart.getDescription())
                .expectedDate(cart.getExpected_date())
                .NumberOfSelectedItems(cart.getNumberOfSelectedItems()) // Use the setter method
                .price(cart.getPrice())
                .material(cart.getMaterial())
                .shape(cart.getShape())
                .productId(cart.getProduct_id())
                .status(cart.getStatus())
                .username(cart.getUsername())
                .build();
        cardDTOList.add(dto);
      }
    }
    int price = 0;
    if (status != null) {
      for (CardDTO cart : cardDTOList) {
        if (cart.getRegularCages() != null && cart.getRegularCages().getCagePrice() != null)
          price +=
              ((cart.getRegularCages().getCagePrice()
                      - cart.getRegularCages().getCagePrice()
                          * cart.getRegularCages().getDiscount())
                  * cart.getNumberOfSelectedItems());
      }
    } else {
      for (CardDTO cart : cardDTOList) {
        if (cart.getPrice() != null) price += cart.getPrice();
      }
    }

    PageDto response =
        PageDto.builder()
            .code(200)
            .message(String.valueOf(price))
            .totalPages(objectPage.getTotalPages())
            .totalItems((int) objectPage.getTotalElements())
            .list(new ArrayList<>(cardDTOList))
            .build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/get/regularCage"})
  public ResponseEntity<?> getUnSolveRegularCage(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "pageSize", required = false) Integer pageSize,
      @RequestParam(name = "username", required = false) String username,
      @RequestParam(name = "status", required = false, defaultValue = "0") Integer status) {
    if (page == null) page = 1;
    if (pageSize == null) pageSize = 1000;

    //        repository.removeAllOrderCustomize(username);
    Page<CartDTOInterface> objectPage = service.getUnSolveRegularCage(username, page, pageSize);
    List<CartDTOInterface> list = objectPage.toList();
    List<CardDTO> cardDTOList = new ArrayList<>(); // Initialize a new ArrayList

    for (CartDTOInterface cart : list) {
      CardDTO dto =
          CardDTO.builder()
              .billId(cart.getBill_id())
              .birdtypeId(cart.getBirdtypeId())
              .createdDate(cart.getCreated_date())
              .datePay(cart.getDate_pay())
              .description(cart.getDescription())
              .expectedDate(cart.getExpected_date())
              .NumberOfSelectedItems(cart.getNumberOfSelectedItems()) // Use the setter method
              .price(cart.getPrice())
              .regularCages(
                  regularCagesRepository.getRegularCagesByCageId(cart.getProduct_id()).orElse(null))
              .material(cart.getMaterial())
              .shape(cart.getShape())
              .productId(cart.getProduct_id())
              .status(cart.getStatus())
              .username(cart.getUsername())
              .build();
      cardDTOList.add(dto);
    }
    int price = 0;
    if (status != null) {
      for (CardDTO cart : cardDTOList) {
        if (cart.getRegularCages() != null && cart.getRegularCages().getCagePrice() != null)
          price +=
              ((cart.getRegularCages().getCagePrice()
                      - cart.getRegularCages().getCagePrice()
                          * cart.getRegularCages().getDiscount())
                  * cart.getNumberOfSelectedItems());
      }
    }
    PageDto response =
        PageDto.builder()
            .code(200)
            .message(String.valueOf(price))
            .totalPages(objectPage.getTotalPages())
            .totalItems((int) objectPage.getTotalElements())
            .list(new ArrayList<>(cardDTOList))
            .build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/get/custom/regularCage"})
  public ResponseEntity<?> getUnSolveCustomRegularCage(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "pageSize", required = false) Integer pageSize,
      @RequestParam(name = "username", required = false) String username,
      @RequestParam(name = "status", required = false, defaultValue = "0") Integer status) {
    if (page == null) page = 1;
    if (pageSize == null) pageSize = 1000;

    //        repository.removeAllOrderCustomize(username);
    Page<CartDTOInterface> objectPage =
        service.getUnSolveCustomRegularCage(username, page, pageSize);
    List<CartDTOInterface> list = objectPage.toList();
    List<CardDTO> cardDTOList = new ArrayList<>(); // Initialize a new ArrayList

    for (CartDTOInterface cart : list) {
      CardDTO dto =
          CardDTO.builder()
              .billId(cart.getBill_id())
              .birdtypeId(cart.getBirdtypeId())
              .createdDate(cart.getCreated_date())
              .datePay(cart.getDate_pay())
              .description(cart.getDescription())
              .expectedDate(cart.getExpected_date())
              .NumberOfSelectedItems(cart.getNumberOfSelectedItems()) // Use the setter method
              .price(cart.getPrice())
              .material(cart.getMaterial())
              .shape(cart.getShape())
              .productId(cart.getProduct_id())
              .status(cart.getStatus())
              .username(cart.getUsername())
              .build();
      cardDTOList.add(dto);
    }
    int price = 0;
    for (CardDTO cart : cardDTOList) {
      if (cart.getPrice() != null) price += cart.getPrice();
    }
    PageDto response =
        PageDto.builder()
            .code(200)
            .message(String.valueOf(price))
            .totalPages(objectPage.getTotalPages())
            .totalItems((int) objectPage.getTotalElements())
            .list(new ArrayList<>(cardDTOList))
            .build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/remove-one"})
  public ResponseEntity<?> removeOne(
      @RequestParam(name = "productId", required = false) Integer productId,
      @RequestParam(name = "username", required = false) String username) {
    service.removeOne(username, productId);
    PageDto response = PageDto.builder().code(200).message("success").build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/remove-atom"})
  public ResponseEntity<?> removeAtom(
      @RequestParam(name = "productId", required = false) Integer productId,
      @RequestParam(name = "username", required = false) String username) {
    service.removeAtom(username, productId);
    PageDto response = PageDto.builder().code(200).message("success").build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/add-to-cart"})
  public ResponseEntity<?> addToCart(
      @RequestParam(name = "productId", required = false) Integer productId,
      @RequestParam(name = "username", required = false) String username,
      @RequestParam(name = "shape", required = false) String shape,
      @RequestParam(name = "material", required = false) String material,
      @RequestParam(name = "description", required = false) String description,
      @RequestParam(name = "birdtypeId", required = false) String birdtypeId,
      @RequestParam(name = "basePrice", required = false) Integer basePrice) {
    var regularCage = regularCagesRepository.getRegularCagesByCageId(productId).orElse(null);
    Integer quantity = regularCage.getQuantity();
    Integer numberOfCageInCart =
        repository.numberOfCage(productId) == null ? 0 : repository.numberOfCage(productId);
    if (numberOfCageInCart < quantity) {
      Cart object = new Cart();
      object.setUsername(username);
      object.setProductId(productId);
      object.setStatus(0);
      if (productId == null) {
        // repository.removeAllOrderCustomize(username); //TH nó đặt hàng, nó hủy thanh
        // toán xong lại vào đặt
        object.setStatus(0);
        object.setShape(shape);
        object.setMaterial(material);
        object.setDescription(description);
        object.setPrice(service.processPriceOrder(shape, material, basePrice));
        object.setBirdtypeId(birdtypeId);
      }

      log.info("Object save|" + object);
      service.addToCart(object);
      PageDto response = PageDto.builder().code(200).message("success").build();
      return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
      PageDto response = PageDto.builder().code(409).message("failed").build();
      return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
  }

  @GetMapping(value = {"/update-account-address"})
  public ResponseEntity<?> updateAddress(
      @RequestParam(name = "address", required = false) String address,
      @RequestParam(name = "username", required = false) String username) {
    var person = accservice.getUsernameorEmail(username, username);
    person.setAddress(address);
    PageDto response =
        PageDto.builder().code(200).message("success").object(accountRepo.save(person)).build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/pay"})
  public ResponseEntity<?> pay(
      @RequestParam(name = "username", required = false) String username,
      @RequestParam(name = "status", required = false) Integer status) {

    String paymentUrl = service.processPay(username, status);
    ApiResponse response = new ApiResponse();
    response.setCode("200");
    response.setMessage("success");
    response.setData(paymentUrl);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/bill"})
  public ResponseEntity<?> bill(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "pageSize", required = false) Integer pageSize,
      @RequestParam(name = "username", required = false) String username,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "paymentID", required = false, defaultValue = "1") Integer paymentID) {
    if (page == null) page = 1;
    if (pageSize == null) pageSize = 1000;
    System.out.println("Payment ID " + paymentID);
    Page<Cart> cartPage = service.bill(username, status, page, pageSize, paymentID);
    service.removeAll(username);
    PageDto response =
        PageDto.builder()
            .code(200)
            .message("success")
            .totalPages(cartPage.getTotalPages())
            .totalItems((int) cartPage.getTotalElements())
            .list(new ArrayList<>(cartPage.toList()))
            .build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/bill-all"})
  public ResponseEntity<?> billAll(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "pageSize", required = false) Integer pageSize,
      @RequestParam(name = "status", required = false) Integer status) {
    if (page == null) page = 1;
    if (pageSize == null) pageSize = 1000;
    Pageable pageable = PageRequest.of(page - 1, pageSize);
    Integer productId = null;
    List<CartDTO> dtoList = new ArrayList<>();
    if (status != null) {
      productId = 1;
    }
    Page<Cart> cartPage = repository.getAllBill(productId, pageable);
    for (Cart cart : cartPage) {
      var person = accservice.getUsernameorEmail(cart.getUsername(), cart.getUsername());

      CartDTO cartDTO =
          CartDTO.builder()
              .id(cart.getId())
              .email(person.getEmail())
              .address(person.getAddress())
              .full_name(person.getFirstName() + " " + person.getLastName())
              .phone(person.getPhone())
              .billId(cart.getBillId())
              .birdtypeId(cart.getBirdtypeId())
              .createdDate(cart.getCreatedDate())
              .datePay(cart.getDatePay())
              .shape(cart.getShape())
              .description(cart.getDescription())
              .expectedDate(cart.getExpectedDate())
              .material(cart.getMaterial())
              .price(cart.getPrice())
              .productId(cart.getProductId())
              .status(cart.getStatus())
              .username(cart.getUsername())
              .totalPrice(
                  (int)
                      (cart.getRegularCages().getCagePrice()
                          - cart.getRegularCages().getCagePrice()
                              * cart.getRegularCages().getDiscount()))
              .build();
      dtoList.add(cartDTO);
    }
    PageDto response =
        PageDto.builder()
            .code(200)
            .message(repository.sumPriceBillAll())
            .totalPages(cartPage.getTotalPages())
            .totalItems((int) cartPage.getTotalElements())
            .list(new ArrayList<>(dtoList))
            .build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/bill-all/product-custom"})
  public ResponseEntity<?> billAllProductCustom(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "pageSize", required = false) Integer pageSize,
      @RequestParam(name = "status", required = false) Integer status) {
    if (page == null) page = 1;
    if (pageSize == null) pageSize = 1000;
    Pageable pageable = PageRequest.of(page - 1, pageSize);
    Integer productId = null;
    //    if (status != null) {
    //      productId = 1;
    //    }
    int count = 1;
    List<CartDTO> dtoList = new ArrayList<>();
    Page<Cart> cartPage = repository.getAllBillProductCustom(productId, pageable);

    for (Cart cart : cartPage) {
      var person = accservice.getUsernameorEmail(cart.getUsername(), cart.getUsername());

      CartDTO cartDTO =
          CartDTO.builder()
              .id(cart.getId())
              .email(person.getEmail())
              .address(person.getAddress())
              .full_name(person.getFirstName() + " " + person.getLastName())
              .phone(person.getPhone())
              .billId(cart.getBillId())
              .birdtypeId(cart.getBirdtypeId())
              .createdDate(cart.getCreatedDate())
              .datePay(cart.getDatePay())
              .shape(cart.getShape())
              .description(cart.getDescription())
              .expectedDate(cart.getExpectedDate())
              .material(cart.getMaterial())
              .price(cart.getPrice())
              .productId(cart.getProductId())
              .customCage_id(count)
              .status(cart.getStatus())
              .username(cart.getUsername())
              .totalPrice(null)
              .build();
      count++;
      dtoList.add(cartDTO);
    }
    PageDto response =
        PageDto.builder()
            .code(200)
            .message(repository.sumPriceBillAll())
            .totalPages(cartPage.getTotalPages())
            .totalItems((int) cartPage.getTotalElements())
            .list(new ArrayList<>(dtoList))
            .build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/price-by-id"})
  public ResponseEntity<?> billAllPRICE(
      @RequestParam(name = "username", required = false) String username) {
    PageDto response =
        PageDto.builder().code(200).message(repository.sumPriceById(username)).build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/change-status"})
  public ResponseEntity<?> changeStatus(
      @RequestParam(name = "username") String username,
      @RequestParam(name = "status") Integer status,
      @RequestParam(name = "cartID") Integer id) {
    var cart = repository.getCartByIdAndUsername(id, username).orElse(null);
    if (cart != null) {
      cart.setStatus(status);
      PageDto response = PageDto.builder().code(200).message("Successfully").build();
      repository.save(cart);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }
  }

  @GetMapping(value = {"/details"})
  public ResponseEntity<?> getDetails(
      @RequestParam(name = "username") String username, @RequestParam(name = "cartID") Integer id) {
    var cart = repository.getHistoryDetails(username, id).orElse(null);
    var person = accservice.getUsernameorEmail(cart.getUsername(), cart.getUsername());
    HistoryObject cartObject =
        HistoryObject.builder()
            .cage_code(cart.getCage_code())
            .cage_name(cart.getCage_name())
            .cage_price(cart.getCage_price())
            .totalPrice((int) (cart.getCage_price() - cart.getCage_price() * cart.getDiscount()))
            .discount(cart.getDiscount())
            .image_url(cart.getImage_url())
            .long_decription(cart.getLong_decription())
            .quantity(cart.getQuantity())
            .short_decription(cart.getShort_decription())
            .customer(person)
            .datePay(cart.getDate_pay())
            .NumberOfSelectedItems(cart.getNumberOfSelectedItems())
            .expectedDate(cart.getExpected_date())
            .price(cart.getPrice())
            .material(cart.getMaterial())
            .shape(cart.getShape())
            .description(cart.getDescription())
            .status(cart.getStatus())
            .productId(cart.getProduct_id())
            .payment(paymentRepo.findPaymentByPaymentId(cart.getPayment_id()).orElse(null))
            .createdDate(cart.getCreated_date())
            .billId(cart.getBill_id())
            .build();
    if (cart != null) {
      PageDto response =
          PageDto.builder().code(200).object(cartObject).message("Successfully").build();
      return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = {"/remove-all-customize"})
  public ResponseEntity<?> removeAllCustomize(
      @RequestParam(name = "username", required = false) String username) {
    repository.removeAllOrderCustomize(username);
    PageDto response = PageDto.builder().code(200).message("success").build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = {"/add-to-cart-v2"})
  public ResponseEntity<?> addToCartV2(@RequestBody AddCartDto addCartDto) {
    //    , @RequestBody(required = true) LoginDTO user
    //    if (accservice.checkLogin(user.getUsername(), user.getUsername()) != null) {
    Cart cart = new Cart();
    cart.setUsername(addCartDto.getUsername());
    cart.setCustom_ProductId(addCartDto.getProductId());
    if (addCartDto.getProductId() == null) {
      // repository.removeAllOrderCustomize(addCartDto.getUsername()); //TH nó đặt hàng,
      // nó hủy thanh toán xong lại vào đặt
      cart.setStatus(0);
      cart.setShape(addCartDto.getShape());
      cart.setMaterial(addCartDto.getMaterial());
      cart.setDescription(addCartDto.getDescription());
      cart.setPrice(
          service.processPriceOrder(
              addCartDto.getShape(), addCartDto.getMaterial(), addCartDto.getBasePrice()));
      cart.setPayment_id(2);
      cart.setBirdtypeId(addCartDto.getBirdtypeId());
    }
    log.info("Object save|" + cart);
    service.addToCart(cart);
    PageDto response = PageDto.builder().code(200).message("success").build();
    return new ResponseEntity<>(response, HttpStatus.OK);
    //    } else {
    //      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    //    }
  }

  @GetMapping(value = {"/history"})
  public ResponseEntity<?> history(
      @RequestParam(name = "username", required = false) String username) {
    try {
      List<HistoryDTO> hisList = repository.getHistory(username);
      List<HistoryObject> histories = new ArrayList<>();
      for (HistoryDTO history : hisList) {
        var person = accservice.getUsernameorEmail(history.getUsername(), history.getUsername());
        HistoryObject historyObject =
            HistoryObject.builder()
                .cage_code(history.getCage_code())
                .cage_name(history.getCage_name())
                .cage_price(history.getCage_price())
                .totalPrice(
                    (int)
                        (history.getCage_price() - history.getCage_price() * history.getDiscount()))
                .discount(history.getDiscount())
                .image_url(history.getImage_url())
                .long_decription(history.getLong_decription())
                .quantity(history.getQuantity())
                .short_decription(history.getShort_decription())
                .customer(person)
                .datePay(history.getDate_pay())
                .NumberOfSelectedItems(history.getNumberOfSelectedItems())
                .expectedDate(history.getExpected_date())
                .price(history.getPrice())
                .material(history.getMaterial())
                .shape(history.getShape())
                .description(history.getDescription())
                .status(history.getStatus())
                .productId(history.getProduct_id())
                .createdDate(history.getCreated_date())
                .billId(history.getBill_id())
                .payment(paymentRepo.findPaymentByPaymentId(history.getPayment_id()).orElse(null))
                .build();
        histories.add(historyObject);
      }
      PageDto response = PageDto.builder().code(200).message("success").object(histories).build();
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      var list = Collections.emptyList();
      return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = {"/by-bill-id"})
  public ResponseEntity<?> billAllByBillId(
      @RequestParam(name = "page", required = false) Integer page,
      @RequestParam(name = "pageSize", required = false) Integer pageSize,
      @RequestParam(name = "bill_id", required = false) Integer billId) {
    if (page == null) page = 1;
    if (pageSize == null) pageSize = 1000;
    Pageable pageable = PageRequest.of(page - 1, pageSize);
    Page<Cart> cartPage = repository.getAllByBillId(billId, pageable);
    PageDto response =
        PageDto.builder()
            .code(200)
            .message("success")
            .totalPages(cartPage.getTotalPages())
            .totalItems((int) cartPage.getTotalElements())
            .list(new ArrayList<>(cartPage.toList()))
            .build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = {"/custom/details"})
  public ResponseEntity<?> detailsCustom(
      @RequestParam(name = "username", required = false) String username,
      @RequestParam(name = "cartID") Integer id) {
    try {
      var cus = repository.findCartByIdAndProductIdIsNullAndUsername(id, username);
      var person = accservice.getUsernameorEmail(username, username);
      PageDto response =
          PageDto.builder()
              .code(200)
              .message("success")
              .object(person)
              .list(Collections.singletonList(cus))
              .build();
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      var list = Collections.emptyList();
      return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = {"/custom/history"})
  public ResponseEntity<?> historyCustom(
      @RequestParam(name = "username", required = false) String username) {
    try {
      List<Cart> hisList = repository.getAllByProductIdIsNullAndUsername(username);
      var person = accservice.getUsernameorEmail(username, username);
      PageDto response =
          PageDto.builder()
              .code(200)
              .message("success")
              .object(person)
              .list(Arrays.asList(hisList.toArray()))
              .build();
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      var list = Collections.emptyList();
      return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = {"/update-status"})
  public ResponseEntity<?> updateStatusByBillId(
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "billId", required = false) Integer billId) {
    repository.updateStatusByBillId(status, billId);
    PageDto response = PageDto.builder().code(200).message("success").build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
