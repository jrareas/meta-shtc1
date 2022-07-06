SUMMARY = "Example of how to build an external Linux kernel module"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

inherit module

SRC_URI = "file://Makefile \
           https://raw.githubusercontent.com/torvalds/linux/v5.18/drivers/hwmon/shtc1.c;protocol=http \
           file://COPYING \
          "
SRC_URI[sha256sum] = "9ec7b10760b903a08b4172e5b76a156f36ff3191a1090fef9e74a2ec5b962be4"

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES_${PN} += "kernel-module-shtc1"

MACHINE_EXTRA_RDEPENDS += "kernel-module-shtc1"
