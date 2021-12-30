package com.example.changeconstraintsettest


const val constraintsA = """
                                    {
                                      txt_hello: {
                                        top: [
                                          'parent',
                                          'top',
                                          8
                                        ],
                                        start: [
                                          'parent',
                                          'start'
                                        ],
                                        end: [
                                          'parent',
                                          'end'
                                        ]
                                      },
                                      txt_test: {
                                        top: [
                                          'txt_hello',
                                          'bottom',
                                          8
                                        ],
                                        end: [
                                          'parent',
                                          'end'
                                        ]
                                      },
                                      img_settings: {
                                        width: 40,
                                        height: 40,
                                        top: [
                                          'txt_test',
                                          'bottom',
                                          8
                                        ],                                  
                                        start: [
                                          'parent',
                                          'start'
                                        ],
                                        end: [
                                          'parent',
                                          'end'
                                        ]
                                      }
                                    }
                                """

const val constraintsB = """
                                    {
                                      txt_hello: {
                                        top: [
                                          'parent',
                                          'top',
                                          16
                                        ],
                                        start: [
                                          'parent',
                                          'start'
                                        ],
                                        end: [
                                          'parent',
                                          'end'
                                        ]
                                      },
                                      txt_test: {
                                        top: [
                                          'txt_hello',
                                          'bottom',
                                          8
                                        ],
                                        end: [
                                          'parent',
                                          'end'
                                        ]
                                      },
                                      img_settings: {
                                        width: 10,
                                        height: 10,
                                        elevation: '8'
                                        top: [
                                          'txt_test',
                                          'bottom',
                                          8
                                        ],    
                                        end: [
                                          'parent',
                                          'end'
                                        ]
                                      }
                                    }
                                """